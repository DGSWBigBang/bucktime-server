package com.bigbang.bucktime.domain.order.dto.reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowOrderResponse {
    private Integer orderIdx;
    private String orderTime;
    private String menuName;
    private String cafeName;
    private String completion;
}
