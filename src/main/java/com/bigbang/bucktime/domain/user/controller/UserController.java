package com.bigbang.bucktime.domain.user.controller;

import com.bigbang.bucktime.domain.user.dto.SignupRequest;
import com.bigbang.bucktime.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
        userService.signup(signupRequest);
        return ResponseEntity.ok("회원가입 완료");
    }
}