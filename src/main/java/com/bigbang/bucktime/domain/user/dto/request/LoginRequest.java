package com.bigbang.bucktime.domain.user.dto.request;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String userMail;
    private String password;
}
