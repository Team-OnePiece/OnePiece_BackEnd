package com.example.onepiece.global.security.error.exception;

import com.example.onepiece.global.security.error.ErrorCode;

public class PasswordMissMatchException extends CustomException{

    public static final CustomException EXCEPTION = new PasswordMissMatchException();

    private PasswordMissMatchException(){
        super(ErrorCode.PASSWORD_MISS_MATCH);
    }

}
