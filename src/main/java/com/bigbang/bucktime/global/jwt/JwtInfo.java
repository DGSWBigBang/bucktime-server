package com.bigbang.bucktime.global.jwt;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtInfo {
    private String grantType;
    private String accessToken;
    private String refreshToken;
}