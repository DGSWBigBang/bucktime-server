package com.bigbang.bucktime.domain.user.controller;

import com.bigbang.bucktime.domain.user.dto.entity.UserEntity;
import com.bigbang.bucktime.domain.user.dto.request.LoginRequest;
import com.bigbang.bucktime.domain.user.dto.request.ModifyUserRequest;
import com.bigbang.bucktime.domain.user.dto.request.SignupRequest;
import com.bigbang.bucktime.domain.user.dto.response.ShowUserResponse;
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

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody SignupRequest signupRequest) {
        userService.addAccount(signupRequest);
        return ResponseEntity.ok("회원 가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtInfo> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAccount(HttpServletRequest request) {
        userService.deleteAccount(request);
        return ResponseEntity.ok("회원 탈퇴 완료");
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyUser(@RequestBody ModifyUserRequest modifyUserRequest) {
        userService.modifyUser(modifyUserRequest);
        return ResponseEntity.ok("회원 수정 완료");
    }

    @GetMapping("/show")
    public ResponseEntity<ShowUserResponse> showUser(HttpServletRequest request) {
        return ResponseEntity.ok(userService.showUser(request));
    }
}