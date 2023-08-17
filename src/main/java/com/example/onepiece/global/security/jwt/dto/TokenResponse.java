package com.example.onepiece.global.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponsee {

    private final String accessToken;
    private final Long expiredAt;
}