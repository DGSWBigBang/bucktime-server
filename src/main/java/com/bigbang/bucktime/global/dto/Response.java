package com.bigbang.bucktime.global.dto;

import lombok.Getter;

@Getter
public class Response {
    private String message;

    public Response (String message) {
        this.message = message;
    }

    public static Response of(String message) {
        return new Response(message);
    }
}
