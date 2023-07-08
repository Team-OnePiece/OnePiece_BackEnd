package com.example.User.global.security.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "User Not Found"),
    USERId_ALREADY_EXISTS(409, "UserId Already Exists"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),

    INTERNAL_SERVER_ERROR(500, "");

    private final Integer httpStatus;
    private final String message;
}
