package com.example.onepiece.User.global.security.jwt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class RefreshToken {

    @Id
    private String accountId;

    private String refreshToken;

    private Long refreshTokenTime;
}
