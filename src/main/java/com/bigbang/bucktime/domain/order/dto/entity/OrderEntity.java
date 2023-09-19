package com.bigbang.bucktime.domain.order.dto.entity;

import lombok.Getter;

@Getter
public class OrderEntity {
    private Integer orderIdx;
    private String orderTime;
    private Integer menuIdx;
    private String userMail;
    private Integer completion;
}
