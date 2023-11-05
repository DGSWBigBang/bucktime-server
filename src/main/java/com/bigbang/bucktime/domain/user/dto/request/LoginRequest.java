package com.bigbang.bucktime.domain.user.dto.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginRequest {
    private String userMail;
    private String password;
}
