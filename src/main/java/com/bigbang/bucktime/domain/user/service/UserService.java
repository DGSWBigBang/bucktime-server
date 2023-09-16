package com.bigbang.bucktime.domain.user.service;

import com.bigbang.bucktime.domain.user.dao.UserMapper;
import com.bigbang.bucktime.domain.user.dto.request.LoginRequest;
import com.bigbang.bucktime.domain.user.dto.request.ModifyUserRequest;
import com.bigbang.bucktime.domain.user.dto.request.SignupRequest;
import com.bigbang.bucktime.global.jwt.JwtInfo;
import com.bigbang.bucktime.global.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDetailService userDetailService;
    private final JwtProvider jwtProvider;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void addAccount(SignupRequest signupRequest) {
        signupRequest.setUserPassword(bCryptPasswordEncoder.encode(signupRequest.getUserPassword()));
        userMapper.insertUser(signupRequest);
    }

    public JwtInfo login(LoginRequest loginRequest) {
        UserDetails user = userDetailService.loadUserByUsername(loginRequest.getUserMail());
        if(bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return jwtProvider.generateToken(user);
        } else {
            return null;
        }
    }

    public void deleteAccount(HttpServletRequest request) {
        userMapper.deleteByUserMail(jwtProvider.getUserMail(request));
    }

    public void modifyUser(ModifyUserRequest modifyUserRequest) {
        userMapper.modifyUser(modifyUserRequest);
    }
}
