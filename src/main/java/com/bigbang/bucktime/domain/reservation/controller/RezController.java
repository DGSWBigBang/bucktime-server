package com.bigbang.bucktime.domain.reservation.controller;

import com.bigbang.bucktime.domain.reservation.dto.request.CreateRezRequest;
import com.bigbang.bucktime.domain.reservation.service.RezService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
