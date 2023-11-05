package com.bigbang.bucktime.domain.reservation.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class InsertReservationData {
    private String startTime;
    private String finishTime;
    private Integer deskIdx;
    private String userMail;

    @Builder
    public InsertReservationData(String startTime, String finishTime, Integer deskIdx, String userMail) {
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.deskIdx = deskIdx;
        this.userMail = userMail;
    }
}
