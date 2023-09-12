package com.bigbang.bucktime.domain.user.controller;

import com.bigbang.bucktime.domain.user.dto.request.LoginRequest;
import com.bigbang.bucktime.domain.user.dto.request.SignupRequest;
import com.bigbang.bucktime.domain.user.service.UserService;
import com.bigbang.bucktime.global.jwt.JwtInfo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/add-account")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
        userService.addAccount(signupRequest);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtInfo> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<String> deleteAccount(HttpServletRequest request) {
        userService.deleteAccount(request);
        return ResponseEntity.ok("회원탈퇴 완료");
    }
}