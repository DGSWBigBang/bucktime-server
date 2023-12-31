package com.bigbang.bucktime.domain.reservation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShowReservationResponse {
    private Integer rezIdx;
    private String deskName;
    private String startTime;
    private String finishTime;
    private String userMail;
}
