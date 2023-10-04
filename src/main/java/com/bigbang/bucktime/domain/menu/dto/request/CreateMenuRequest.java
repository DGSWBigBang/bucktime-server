package com.bigbang.bucktime.domain.menu.dto.request;

import lombok.Getter;

@Getter
public class CreateMenuRequest {
    private String menuName;
    private String menuDescription;
    private Integer menuPrice;
    private Integer cafeIdx;
}
