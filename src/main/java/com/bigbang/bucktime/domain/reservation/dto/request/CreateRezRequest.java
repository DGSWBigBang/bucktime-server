package com.bigbang.bucktime.domain.reservation.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateRezRequest {
    private Integer hours;
    private Integer deskIdx;
}
