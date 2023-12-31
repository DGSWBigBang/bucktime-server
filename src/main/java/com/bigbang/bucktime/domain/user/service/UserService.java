package com.bigbang.bucktime.domain.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bigbang.bucktime.domain.user.dao.UserMapper;
import com.bigbang.bucktime.domain.user.dto.request.DuplicateRequest;
import com.bigbang.bucktime.domain.user.dto.request.LoginRequest;
import com.bigbang.bucktime.domain.user.dto.request.ModifyUserRequest;
import com.bigbang.bucktime.domain.user.dto.request.SignupRequest;
import com.bigbang.bucktime.domain.user.dto.response.ShowUserResponse;
import com.bigbang.bucktime.global.jwt.JwtInfo;
import com.bigbang.bucktime.global.jwt.JwtProvider;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDetailService userDetailService;
    private final JwtProvider jwtProvider;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addAccount(SignupRequest signupRequest) {
        signupRequest.setUserPassword(bCryptPasswordEncoder.encode(signupRequest.getUserPassword()));
        userMapper.insertUser(signupRequest);
    }

    public JwtInfo login(LoginRequest loginRequest) {
        UserDetails user = userDetailService.loadUserByUsername(loginRequest.getUserMail());
        
        if (user == null) {
        	throw new RuntimeException("User not found");
        } else {
            if(bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return jwtProvider.generateToken(user);
            } else {
                throw new RuntimeException("Password mismatch");
            }
        }
    }

    public void deleteAccount(HttpServletRequest request) {
        userMapper.deleteByUserMail(jwtProvider.getUserMail(request));
    }

    public void modifyUser(ModifyUserRequest modifyUserRequest) {
        modifyUserRequest.setUserPassword(bCryptPasswordEncoder.encode(modifyUserRequest.getUserPassword()));
        userMapper.modifyUser(modifyUserRequest);
    }

    public ShowUserResponse showUser(HttpServletRequest request) {
        return userMapper.showUser(jwtProvider.getUserMail(request));
    }

    public Boolean duplicateCheck(DuplicateRequest request) {
        if(request.getDuplicate().equals("number")) {
            return userMapper.countUserByPhoneNumber(request.getData()) >= 1;
        } else if (request.getDuplicate().equals("mail")) {
            return userMapper.countUserByUserMail(request.getData()) >= 1;
        } else {
            return false;
        }
    }
}
