package com.bigbang.bucktime.global.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    CAFE_NOT_FOUND(404, "존재하지 않는 카페입니다."),

    INVALID_CAFE_INFO(400, "카페 정보가 올바르지 않습니다"),

    UNAUTHORIZED_ERROR(401, "권한이 없습니다"),

    INTERNAL_SERVER_ERROR(500, "서버 오류 입니다. 서버 개발자에게 문의 해주세요.");

    private final int status;
    private final String message;
}
