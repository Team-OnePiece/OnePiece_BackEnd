package com.example.onepiece.user.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "User Not Found"),
    USERID_ALREADY_EXISTS(409, "UserId Already Exists"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),

    JWT_EXPIRED(401, "Jwt Expired"),

    INTERNAL_SERVER_ERROR(500, "");

    private final Integer httpStatus;
    private final String message;
}