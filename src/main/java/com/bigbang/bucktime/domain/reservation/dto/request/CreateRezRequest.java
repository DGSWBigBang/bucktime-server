package com.bigbang.bucktime.domain.reservation.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class CreateRezRequest {
    private Date startTime;
    private Date finishTime;
    private Integer deskIdx;
    private String userMail;
}
