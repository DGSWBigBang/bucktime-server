package com.bigbang.bucktime.global.jwt;

import com.bigbang.bucktime.domain.user.service.UserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtProvider {
    private final Key secretKey;
    private final String issuer;
    private final UserDetailService userDetailService;

    public JwtProvider(@Value("${jwt.secret}") String secret, @Value("${jwt.issuer}") String issuer, UserDetailService userDetailService) {
        byte[] secretByteKey = Decoders.BASE64.decode(secret);
        this.secretKey = Keys.hmacShaKeyFor(secretByteKey);
        this.issuer = issuer;
        this.userDetailService = userDetailService;
    }

    public JwtInfo generateToken(UserDetails user) {
        Long now = new Date().getTime();
        Long day = 1000L * 60 * 60 * 24;
        Long week = 1000L * 60 * 60 * 24 * 7;

        String authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        String accessToken = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("auth", authorities)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + day))
                .setIssuer(issuer)
                .signWith(secretKey)
                .compact();

        String refreshToken = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("auth", authorities)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + week))
                .setIssuer(issuer)
                .signWith(secretKey)
                .compact();

        return JwtInfo.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Authentication getAuthentication(String accessToken) {
        Claims claims = this.parseClaims(accessToken);

        if(claims.get("auth") == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다");
        }
        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        UserDetails principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    public String getUserMail(HttpServletRequest request) {
        return this.parseClaims(this.getToken(request)).getSubject();
    }

    public JwtInfo refreshToken(String refresh) {
        UserDetails user = this.getUserDetails(refresh);
        return this.generateToken(user);
    }

    private UserDetails getUserDetails(String token) {
        Claims claims = parseClaims(token);
        String userEmail = claims.getSubject();
        UserDetails user = userDetailService.loadUserByUsername(userEmail);
        return user;
    }

    public Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }
}
