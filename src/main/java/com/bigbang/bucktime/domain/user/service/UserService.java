package com.bigbang.bucktime.domain.user.service;

import com.bigbang.bucktime.domain.user.dao.UserMapper;
import com.bigbang.bucktime.domain.user.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void signup(SignupRequest signupRequest) {
        signupRequest.setUserPassword(bCryptPasswordEncoder.encode(signupRequest.getUserPassword()));
        userMapper.signup(signupRequest);
    }
}
