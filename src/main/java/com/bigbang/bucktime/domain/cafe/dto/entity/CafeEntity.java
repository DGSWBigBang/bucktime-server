package com.bigbang.bucktime.domain.cafe.dto.entity;

import lombok.Data;

@Data
public class CafeEntity {
    private Integer cafeIdx;
    private String cafeName;
    private String address;
    private String ownerMail;
}