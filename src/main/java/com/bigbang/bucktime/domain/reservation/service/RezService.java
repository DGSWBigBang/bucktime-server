package com.bigbang.bucktime.domain.reservation.service;

import com.bigbang.bucktime.domain.reservation.dao.RezMapper;
import com.bigbang.bucktime.domain.reservation.dto.entity.ReservationEntity;
import com.bigbang.bucktime.domain.reservation.dto.request.CreateRezRequest;
import com.bigbang.bucktime.domain.reservation.dto.response.ShowReservationResponse;
import com.bigbang.bucktime.global.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RezService {
    private final RezMapper rezMapper;
    private final JwtProvider jwtProvider;

    public void createReservation(CreateRezRequest createRezRequest, HttpServletRequest request) {
        createRezRequest.setUserMail(jwtProvider.getUserMail(request));
        rezMapper.createReservation(createRezRequest);
    }

    public List<ShowReservationResponse> showReservation(Integer cafeIdx) {
        List<ReservationEntity> reservationEntityList = rezMapper.showReservation(cafeIdx);
        List<ShowReservationResponse> reservationResponseList = new ArrayList<>();
        for (ReservationEntity reservation: reservationEntityList) {
            ShowReservationResponse reservationResponse = ShowReservationResponse.builder()
                    .rezIdx(reservation.getRezIdx())
                    .deskIdx(reservation.getDeskIdx())
                    .startTime(reservation.getStartTime())
                    .finishTime(reservation.getFinishTime())
                    .userMail(reservation.getUserMail())
                    .used(reservation.getUsed() == 1 ? "사용" : "미사용")
                    .build();
            reservationResponseList.add(reservationResponse);
        }
        return reservationResponseList;
    }

    public void modifyUsed(Integer rezIdx) {
        rezMapper.modifyUsed(rezIdx);
    }
}
