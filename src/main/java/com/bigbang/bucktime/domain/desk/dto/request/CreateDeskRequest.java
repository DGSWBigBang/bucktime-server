package com.bigbang.bucktime.domain.desk.dto.request;

import lombok.Getter;

@Getter
public class CreateDeskRequest {
    private String deskName;
    private Integer cafeIdx;
}
