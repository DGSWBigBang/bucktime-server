package com.bigbang.bucktime.global.exception;

import com.bigbang.bucktime.global.errors.ErrorCode;
import lombok.Getter;

@Getter
public class BadRequestException extends IllegalArgumentException {
    private final ErrorCode errorCode;

    public BadRequestException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }
}
