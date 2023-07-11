package com.example.onepiece.user.global.error.exception;

import com.example.onepiece.user.global.error.ErrorCode;

public class InvalidTokenException extends CustomException {
    public static final CustomException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.JWT_INVALID);
    }
}
