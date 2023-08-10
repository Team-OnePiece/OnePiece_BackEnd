package com.example.onepiece.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "User Not Found"),
    ACCOUNTID_ALREADY_EXISTS(409, "AccountId Already Exists"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),
    STUDENTID_ALREADY_EXISTS(409, "StudentId Already Exists"),
    PASSWORD_MISS_MATCH(400, "Password Miss Match"),

    JWT_EXPIRED(401, "Jwt Expired"),
    JWT_INVALID(401, "Jwt Invalid"),

    IMAGE_UPLOAD_FAILED(400, "Image Upload Failed"),
    IMAGE_VALUE_NOT_FOUND(404, "Image Value Not Found"),

    BOARD_NOT_FOUND(404, "Board Not Found"),
    BOARD_WRITER_MISMATCH(403, "Board Writer Mismatch"),
    BOARD_IMAGE_NOT_FOUND(404, "Board Image Not Found");

    private final Integer httpStatus;
    private final String message;
}
