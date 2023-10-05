package com.bigbang.bucktime.domain.desk.controller;

import com.bigbang.bucktime.domain.desk.dto.entity.DeskEntity;
import com.bigbang.bucktime.domain.desk.dto.request.CreateDeskRequest;
import com.bigbang.bucktime.domain.desk.dto.request.ModifyDeskRequest;
import com.bigbang.bucktime.domain.desk.service.DeskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desk")
@RequiredArgsConstructor
@Tag(name = "DESK CONTROLLER", description = "테이블 정보 생성, 수정, 삭제, 불러오기")
public class DeskController {
    private final DeskService deskService;

    @Operation(summary = "테이블 생성(사장)")
    @PostMapping("/create")
    public ResponseEntity<String> createDesk(@RequestBody CreateDeskRequest createDeskRequest) {
        deskService.createDesk(createDeskRequest);
        return ResponseEntity.ok("테이블 생성 완료");
    }

    @Operation(summary = "테이블 정보 수정(사장)", description = "deskIdx는 식별용")
    @PutMapping("/modify")
    public ResponseEntity<String> modifyDesk(@RequestBody ModifyDeskRequest modifyDeskRequest) {
        deskService.modifyDesk(modifyDeskRequest);
        return ResponseEntity.ok("테이블 변경 완료");
    }

    @Operation(summary = "테이블 삭제(사장)")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDesk(@RequestParam(value = "desk-idx") Integer deskIdx) {
        deskService.deleteDesk(deskIdx);
        return ResponseEntity.ok("테이블 삭제 완료");
    }

    @Operation(summary = "테이블 정보 불러오기")
    @GetMapping("/show")
    public ResponseEntity<List<DeskEntity>> findDesk(@RequestParam(value = "cafe-idx") Integer cafeIdx) {
        return ResponseEntity.ok(deskService.findDesk(cafeIdx));
    }

    @Operation(summary = "테이블 정보 불러오기(사장)")
    @GetMapping("/show/owner")
    public ResponseEntity<List<DeskEntity>> findOwnerDesk(HttpServletRequest request) {
        return ResponseEntity.ok(deskService.findOwnerDesk(request));
    }
}
