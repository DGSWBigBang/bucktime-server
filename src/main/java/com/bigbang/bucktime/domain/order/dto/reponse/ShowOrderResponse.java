package com.bigbang.bucktime.domain.order.dto.reponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ShowOrderResponse {
    private Integer orderIdx;
    private String orderTime;
    private String menuName;
    private String cafeName;
    private String completion;
}
