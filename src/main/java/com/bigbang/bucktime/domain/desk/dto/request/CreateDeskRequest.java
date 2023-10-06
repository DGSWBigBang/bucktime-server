package com.bigbang.bucktime.domain.desk.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDeskRequest {
    private String deskName;
    private Integer cafeIdx;
}
