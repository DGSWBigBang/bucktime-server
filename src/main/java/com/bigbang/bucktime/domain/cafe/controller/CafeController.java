package com.bigbang.bucktime.domain.cafe.controller;

import com.bigbang.bucktime.domain.cafe.dto.entity.CafeEntity;
import com.bigbang.bucktime.domain.cafe.dao.CafeMapper;
import com.bigbang.bucktime.domain.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @PutMapping("/modify")
    public ResponseEntity<String> updateCafeInfo(@RequestBody CafeEntity updatedCafeInfo) {
        if (updatedCafeInfo != null) {
            cafeService.modifyCafe(updatedCafeInfo);
            return ResponseEntity.ok("카페 정보가 업데이트되었습니다.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}