package com.bigbang.bucktime.domain.user.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class DuplicateResponse {
    private Boolean duplicated;

    public DuplicateResponse(Boolean duplicated) {
        this.duplicated = duplicated;
    }

    public static DuplicateResponse of(Boolean duplicated) {
        return new DuplicateResponse(duplicated);
    }
}
