package com.bigbang.bucktime.domain.cafe.dto.request;

import lombok.Getter;

@Getter
public class ModifyCafeInfoRequest {
    private Integer cafeIdx;
    private String cafeName;
    private String cafeDescription;
    private String openTime;
    private String closeTime;
    private String callNumber;
}
