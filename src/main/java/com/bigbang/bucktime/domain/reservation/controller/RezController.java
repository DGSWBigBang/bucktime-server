package com.bigbang.bucktime.domain.reservation.controller;

import com.bigbang.bucktime.domain.reservation.dto.request.CreateRezRequest;
import com.bigbang.bucktime.domain.reservation.dto.response.ShowReservationResponse;
import com.bigbang.bucktime.domain.reservation.service.RezService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rez")
@RequiredArgsConstructor
public class RezController {
    private final RezService rezService;

    @PostMapping("/create")
    public ResponseEntity<String> createReservation(@RequestBody CreateRezRequest createRezRequest, HttpServletRequest request) {
        rezService.createReservation(createRezRequest, request);
        return ResponseEntity.ok("예약 완료");
    }

    @GetMapping("/show")
    public ResponseEntity<List<ShowReservationResponse>> showReservation(@RequestParam("desk-idx") Integer deskIdx) {
        return ResponseEntity.ok(rezService.showReservation(deskIdx));
    }

    @PutMapping("/modify/used")
    public ResponseEntity<String> modifyUsed(@RequestParam("rez-idx") Integer rezIdx) {
        rezService.modifyUsed(rezIdx);
        return ResponseEntity.ok("사용 시작");
    }
}
