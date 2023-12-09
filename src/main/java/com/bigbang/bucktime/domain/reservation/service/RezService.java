package com.bigbang.bucktime.domain.reservation.service;

import com.bigbang.bucktime.domain.desk.dao.DeskMapper;
import com.bigbang.bucktime.domain.reservation.dao.RezMapper;
import com.bigbang.bucktime.domain.reservation.dto.InsertReservationData;
import com.bigbang.bucktime.domain.reservation.dto.entity.ReservationEntity;
import com.bigbang.bucktime.domain.reservation.dto.request.CreateRezRequest;
import com.bigbang.bucktime.domain.reservation.dto.response.ShowReservationResponse;
import com.bigbang.bucktime.global.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RezService {
    private final RezMapper rezMapper;
    private final DeskMapper deskMapper;
    private final JwtProvider jwtProvider;

    public void createReservation(CreateRezRequest createRezRequest, HttpServletRequest request) {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime finishTime = startTime.plusSeconds(createRezRequest.getHours() * 60 * 60);
        InsertReservationData insertData = InsertReservationData.builder()
                .deskIdx(createRezRequest.getDeskIdx())
                .startTime(startTime.toString())
                .finishTime(finishTime.toString())
                .userMail(jwtProvider.getUserMail(request))
                .build();
        rezMapper.createReservation(insertData);
    }

    public List<ShowReservationResponse> showReservationList(Integer cafeIdx) {
        List<ReservationEntity> reservationEntityList = rezMapper.showReservationList(cafeIdx);
        List<ShowReservationResponse> reservationResponseList = new ArrayList<>();
        for (ReservationEntity reservation: reservationEntityList) {
            ShowReservationResponse reservationResponse = ShowReservationResponse.builder()
                    .rezIdx(reservation.getRezIdx())
                    .deskName(deskMapper.findDeskName(reservation.getDeskIdx()))
                    .startTime(reservation.getStartTime())
                    .finishTime(reservation.getFinishTime())
                    .userMail(reservation.getUserMail())
                    .build();
            reservationResponseList.add(reservationResponse);
        }
        return reservationResponseList;
    }

    public void extensionReservation(Integer hours, Integer deskIdx) {
        String finishTime = rezMapper.getFinishTimeByDeskIdx(deskIdx);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime extensionFinishTime = LocalDateTime.parse(finishTime, formatter);
        extensionFinishTime = extensionFinishTime.plusSeconds(hours * 60 * 60);
        rezMapper.extensionFinishTime(deskIdx, extensionFinishTime.toString());
    }

    public ShowReservationResponse showReservation(HttpServletRequest request) {
        String userMail = jwtProvider.getUserMail(request);
        ReservationEntity reservation = rezMapper.showReservationByUserMail(userMail);
        if(reservation == null) {
            return null;
        }
        return ShowReservationResponse.builder()
                .rezIdx(reservation.getRezIdx())
                .deskName(deskMapper.findDeskName(reservation.getDeskIdx()))
                .startTime(reservation.getStartTime())
                .finishTime(reservation.getFinishTime())
                .userMail(reservation.getUserMail())
                .build();
    }
}
