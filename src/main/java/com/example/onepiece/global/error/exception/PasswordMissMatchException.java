package com.example.onepiece.global.error.exception;

import com.example.onepiece.global.error.ErrorCode;

public class PasswordMissMatchException extends CustomException{

    public static final CustomException EXCEPTION = new PasswordMissMatchException();

    private PasswordMissMatchException(){
        super(ErrorCode.PASSWORD_MISS_MATCH);
    }

}
