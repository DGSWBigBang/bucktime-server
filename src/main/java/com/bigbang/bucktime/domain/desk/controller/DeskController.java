package com.bigbang.bucktime.domain.desk.controller;

import com.bigbang.bucktime.domain.desk.dto.entity.DeskEntity;
import com.bigbang.bucktime.domain.desk.dto.request.CreateDeskRequest;
import com.bigbang.bucktime.domain.desk.dto.request.ModifyDeskRequest;
import com.bigbang.bucktime.domain.desk.service.DeskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desk")
@RequiredArgsConstructor
public class DeskController {
    private final DeskService deskService;

    @PostMapping("/create")
    public ResponseEntity<String> createDesk(@RequestBody CreateDeskRequest createDeskRequest) {
        deskService.createDesk(createDeskRequest);
        return ResponseEntity.ok("테이블 생성 완료");
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyDesk(@RequestBody ModifyDeskRequest modifyDeskRequest) {
        deskService.modifyDesk(modifyDeskRequest);
        return ResponseEntity.ok("테이블 변경 완료");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDesk(@RequestParam(value = "desk-idx") Integer deskIdx) {
        deskService.deleteDesk(deskIdx);
        return ResponseEntity.ok("테이블 삭제 완료");
    }

    @GetMapping("/show")
    public ResponseEntity<List<DeskEntity>> findDesk(@RequestParam(value = "cafe-idx") Integer cafeIdx) {
        return ResponseEntity.ok(deskService.findDesk(cafeIdx));
    }
}
