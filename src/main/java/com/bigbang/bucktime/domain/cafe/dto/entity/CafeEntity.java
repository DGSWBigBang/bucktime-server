package com.bigbang.bucktime.domain.cafe.dto.entity;

import lombok.Data;

@Data
public class CafeEntity {
    private Integer cafeIdx;
    private String cafeName;
    private String cafeDescription;
    private String address;
    private String ownerMail;
    private String latitude;
    private String longitude;
    private String openTime;
    private String closeTime;
    private String callNumber;
}