package com.bigbang.bucktime.domain.menu.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMenuRequest {
    private String menuName;
    private String menuDescription;
    private Integer menuPrice;
    private Integer cafeIdx;
}
