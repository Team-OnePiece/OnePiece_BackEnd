package com.example.onepiece.global.security.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    USER_NOT_FOUND(404, "User Not Found"),
    USER_ALREADY_EXISTS(409, "User Already Exists"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists");

    private final Integer httpStatus;
    private final String message;
}
