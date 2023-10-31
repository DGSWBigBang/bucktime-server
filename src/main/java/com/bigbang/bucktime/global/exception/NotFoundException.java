package com.bigbang.bucktime.global.exception;

import com.bigbang.bucktime.global.errors.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }
}
