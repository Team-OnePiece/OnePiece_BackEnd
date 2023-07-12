package com.example.onepiece.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "User Not Found"),
    USERID_ALREADY_EXISTS(409, "UserId Already Exists"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),
    PASSWORD_MISS_MATCH(400, "Password Miss Match"),

<<<<<<< HEAD:src/main/java/com/example/onepiece/user/global/error/ErrorCode.java
    JWT_EXPIRED(401, "Jwt Expired"),
    JWT_INVALID(401, "Jwt Invalid"),

=======
>>>>>>> parent of feb4904... 📑 ::  패키지 구조 변경:src/main/java/com/example/onepiece/user/global/security/error/ErrorCode.java
    INTERNAL_SERVER_ERROR(500, "");

    private final Integer httpStatus;
    private final String message;
}