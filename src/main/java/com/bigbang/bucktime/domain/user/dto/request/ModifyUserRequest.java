package com.bigbang.bucktime.domain.user.dto.request;

import lombok.Getter;

@Getter
public class ModifyUserRequest {
    private String userMail;
    private String userName;
    private String phoneNumber;
    private String userPassword;
}
