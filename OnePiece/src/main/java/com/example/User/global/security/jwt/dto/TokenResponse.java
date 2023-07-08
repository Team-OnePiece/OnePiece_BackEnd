package com.example.User.global.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {

    private String accountId;

    private String refreshToken;

    private Long refreshTokenTime;

}
