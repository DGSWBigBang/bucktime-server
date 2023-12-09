package com.bigbang.bucktime.domain.desk.dto.request;

import lombok.Getter;

@Getter
public class ModifyDeskRequest {
    private Integer deskIdx;
    private String deskName;
    private Integer price;
    private Long capacity;
}
