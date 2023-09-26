package com.bigbang.bucktime.domain.reservation.service;

import com.bigbang.bucktime.domain.reservation.dao.RezMapper;
import com.bigbang.bucktime.domain.reservation.dto.request.CreateRezRequest;
import com.bigbang.bucktime.global.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RezService {
    private final RezMapper rezMapper;
    private final JwtProvider jwtProvider;

    public void createReservation(CreateRezRequest createRezRequest, HttpServletRequest request) {
        createRezRequest.setUserMail(jwtProvider.getUserMail(request));
        rezMapper.createReservation(createRezRequest);
    }
}
