package com.bigbang.bucktime.domain.user.controller;

import com.bigbang.bucktime.domain.user.dto.request.DuplicateRequest;
import com.bigbang.bucktime.domain.user.dto.request.LoginRequest;
import com.bigbang.bucktime.domain.user.dto.request.ModifyUserRequest;
import com.bigbang.bucktime.domain.user.dto.request.SignupRequest;
import com.bigbang.bucktime.domain.user.dto.response.DuplicateResponse;
import com.bigbang.bucktime.domain.user.dto.response.ShowUserResponse;
import com.bigbang.bucktime.domain.user.service.UserService;
import com.bigbang.bucktime.global.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "USER CONTROLLER", description = "회원가입, 로그인, 회원 탈퇴, 회원 정보 수정, 불러오기")
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원 가입")
    @PostMapping("/create")
    public ResponseEntity<Response> createUser(@RequestBody SignupRequest signupRequest) {
        userService.addAccount(signupRequest);
        return ResponseEntity.ok(Response.of("회원가입 완료"));
    }

    @PostMapping("/create1")
    public ResponseEntity<Response> createUser1(@ModelAttribute SignupRequest signupRequest) {
        userService.addAccount(signupRequest);
        return ResponseEntity.ok(Response.of("회원가입 완료"));
    }

    @Operation(summary = "로그인", description = "로그인 방식은 jwt 방식임 헤더의 Authorization를 Bearer (accessToken)로 설정 해야함")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
        	return ResponseEntity.ok(userService.login(loginRequest));
        } catch (Exception e) {
        	return ResponseEntity.status(500).body(e.getMessage());
		}
    }

    @Operation(summary = "회원 탈퇴(유저)")
    @DeleteMapping("/delete")
    public ResponseEntity<Response> deleteAccount(HttpServletRequest request) {
        userService.deleteAccount(request);
        return ResponseEntity.ok(Response.of("회원 탈퇴 완료"));
    }

    @Operation(summary = "회원 정보 수정(유저)")
    @PutMapping("/modify")
    public ResponseEntity<Response> modifyUser(@RequestBody ModifyUserRequest modifyUserRequest) {
        userService.modifyUser(modifyUserRequest);
        return ResponseEntity.ok(Response.of("회원 수정 완료"));
    }

    @Operation(summary = "회원 정보 불러오기(유저)", description = "비밀번호 제외 이메일, 이름, 전화번호를 반환")
    @GetMapping("/show")
    public ResponseEntity<ShowUserResponse> showUser(HttpServletRequest request) {
        return ResponseEntity.ok(userService.showUser(request));
    }

    @Operation(summary = "중복 체크", description = "바디의 데이터중 duplicate가 number이면 전화번호 중복 체크, mail이면 이메일 중복 체크, 둘다 아니면 false 반환")
    @PostMapping("/duplicate-check")
    public ResponseEntity<DuplicateResponse> duplicateCheck(@RequestBody DuplicateRequest request) {
        return ResponseEntity.ok(DuplicateResponse.of(userService.duplicateCheck(request)));
    }
}