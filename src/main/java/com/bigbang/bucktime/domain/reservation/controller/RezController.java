package com.bigbang.bucktime.domain.reservation.controller;

import com.bigbang.bucktime.domain.reservation.dto.entity.ReservationEntity;
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
    public ResponseEntity<List<ShowReservationResponse>> showReservationList(@RequestParam("desk-idx") Integer deskIdx) {
        return ResponseEntity.ok(rezService.showReservationList(deskIdx));
    }

    @Operation(summary = "자기 예약 보기", description = "이미 시간이 지난거도 보임")
    @GetMapping("/show/user")
    public ResponseEntity<?> showReservation(HttpServletRequest request) {
        ShowReservationResponse response = rezService.showReservation(request);
        if(response == null) {
            return ResponseEntity.ok(Response.of("예약이 없습니다."));
        }
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "연장(유저)", description = "사용 연장 1시간 단위, hours는 몇시간 연장 할 것인지 desk-idx는 어떤 테이블을 연장 시킬 것인지")
    @GetMapping("/extension")
    public ResponseEntity<Response> extensionReservation(@RequestParam(name = "hours") Integer hours, @RequestParam("desk-idx") Integer deskIdx) {
        rezService.extensionReservation(hours, deskIdx);
        return ResponseEntity.ok(Response.of("연장 완료"));
    }
}
