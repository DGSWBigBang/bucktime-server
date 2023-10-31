package com.bigbang.bucktime.global.errors;

import com.bigbang.bucktime.global.exception.BadRequestException;
import com.bigbang.bucktime.global.exception.NotFoundException;
import com.bigbang.bucktime.global.exception.UnauthorizedException;
import com.bigbang.bucktime.global.utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(NotFoundException e) {
        log.error(e.getMessage());
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(ApiResponse.error(errorCode), HttpStatusCode.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handleBadRequestException(BadRequestException e) {
        log.error(e.getMessage());
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(ApiResponse.error(errorCode), HttpStatusCode.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponse> handleUnauthorizedException(UnauthorizedException e) {
        log.error(e.getMessage());
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(ApiResponse.error(errorCode), HttpStatusCode.valueOf(errorCode.getStatus()));
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiResponse> handleException(Exception e) {
//        log.error(e.getMessage(), e);
//        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
//        return new ResponseEntity<>(ApiResponse.error(errorCode), HttpStatus.valueOf(errorCode.getStatus()));
//    }
}
