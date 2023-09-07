package com.bigbang.bucktime.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    private String userMail;
    private String userName;
    private String phoneNumber;
    private String userPassword;
}
