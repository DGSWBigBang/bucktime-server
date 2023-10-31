package com.bigbang.bucktime.domain.reservation.controller;

import com.bigbang.bucktime.domain.reservation.dto.request.CreateRezRequest;
import com.bigbang.bucktime.domain.reservation.dto.response.ShowReservationResponse;
import com.bigbang.bucktime.domain.reservation.service.RezService;
import com.bigbang.bucktime.global.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rez")
@RequiredArgsConstructor
@Tag(name = "RESERVATION CONTROLLER", description = "예약, 예약 정보 불러오기, 사용")
public class RezController {
    private final RezService rezService;

    @Operation(summary = "예약(유저)")
    @PostMapping("/create")
    public ResponseEntity<Response> createReservation(@RequestBody CreateRezRequest createRezRequest, HttpServletRequest request) {
        rezService.createReservation(createRezRequest, request);
        return ResponseEntity.ok(Response.of("예약 완료"));
    }

    @Operation(summary = "예약 정보 불러오기", description = "이미 시간이 지났거나 사용된 것 된 것도 나옴")
    @GetMapping("/show")
    public ResponseEntity<List<ShowReservationResponse>> showReservation(@RequestParam("desk-idx") Integer deskIdx) {
        return ResponseEntity.ok(rezService.showReservation(deskIdx));
    }

    @Operation(summary = "사용 시작(유저)", description = "예약한 사용자가 사용 시작할때")
    @PutMapping("/modify/used")
    public ResponseEntity<Response> modifyUsed(@RequestParam("rez-idx") Integer rezIdx) {
        rezService.modifyUsed(rezIdx);
        return ResponseEntity.ok(Response.of("사용 시작"));
    }
}
