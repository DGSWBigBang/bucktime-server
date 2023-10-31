package com.bigbang.bucktime.global.exception;

import com.bigbang.bucktime.global.errors.ErrorCode;
import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {
    private final ErrorCode errorCode;

    public UnauthorizedException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }
}
