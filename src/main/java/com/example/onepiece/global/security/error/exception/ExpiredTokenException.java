package com.example.onepiece.global.security.error.exception;

import com.example.onepiece.global.security.error.ErrorCode;

public class ExpiredTokenException extends CustomException{

    public static final CustomException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
