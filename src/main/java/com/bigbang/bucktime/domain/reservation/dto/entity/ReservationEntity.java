package com.bigbang.bucktime.domain.reservation.dto.entity;

import lombok.Getter;

@Getter
public class ReservationEntity {
    private Integer rezIdx;
    private String startTime;
    private String finishTime;
    private String userMail;
    private Integer deskIdx;
    private Integer used;
}
