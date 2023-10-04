package com.bigbang.bucktime.domain.menu.dto.response;

import lombok.Getter;

@Getter
public class ShowMenuResponse {
    private Integer menuIdx;
    private String menuName;
    private String menuDescription;
    private Integer menuPrice;
}
