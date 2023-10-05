package com.bigbang.bucktime.domain.cafe.controller;

import com.bigbang.bucktime.domain.cafe.dto.entity.CafeEntity;
import com.bigbang.bucktime.domain.cafe.dto.request.ModifyCafeInfoRequest;
import com.bigbang.bucktime.domain.cafe.service.CafeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
@Tag(name = "CAFE CONTROLLER", description = "카페 정보 수정, 불러오기")
public class CafeController {
    private final CafeService cafeService;

    @Operation(summary = "카페 정보 수정(사장)", description = "cafeIdx는 식별용")
    @PutMapping("/modify")
    public ResponseEntity<String> updateCafeInfo(@RequestBody ModifyCafeInfoRequest updatedCafeInfo) {
        cafeService.modifyCafe(updatedCafeInfo);
        return ResponseEntity.ok("카페 정보가 업데이트되었습니다.");
    }

    @Operation(summary = "카페 정보 요청", description = "사실 ownerMail은 쓰잘때기 없음")
    @GetMapping("/show")
    public ResponseEntity<List<CafeEntity>> showCafeInfo() {
        return ResponseEntity.ok(cafeService.showCafeInfo());
    }

    @Operation(summary = "카페 정보 요청(사장)")
    @GetMapping("/show/owner")
    public ResponseEntity<CafeEntity> showOwnerCafeInfo(HttpServletRequest request) {return ResponseEntity.ok(cafeService.showOwnerCafeInfo(request));}
}