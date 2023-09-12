package com.bigbang.bucktime.domain.user.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SignupRequest {
    private String userMail;
    private String userName;
    private String phoneNumber;
    private String userPassword;
}
