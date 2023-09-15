package com.bigbang.bucktime.domain.menu.dto.request;

import lombok.Getter;

@Getter
public class ModifyMenuRequest {
    private Integer menuIdx;
    private String menuName;
    private String menuDescription;
    private Integer menuPrice;
}
