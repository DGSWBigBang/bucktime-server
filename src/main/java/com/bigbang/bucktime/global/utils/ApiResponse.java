package com.bigbang.bucktime.global.utils;


import com.bigbang.bucktime.global.errors.ErrorCode;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final Boolean success;
    private final T response;
    private final String error;

    public static <T> ApiResponse<T> success(T response) {
        return new ApiResponse<>(true, response, null);
    }

    public static <T> ApiResponse<T> error(ErrorCode errorCode) {
        return new ApiResponse<>(false, null, errorCode);
    }

    public ApiResponse(Boolean success, T response, ErrorCode error) {
        this.success = success;
        this.response = response;
        this.error = error.getMessage();
    }
}
