package com.example.onepiece.user.global.error.exception;

import com.example.onepiece.user.global.error.ErrorCode;

public class PasswordMIssMatchException extends CustomException{

    public static final CustomException EXCEPTION = new PasswordMIssMatchException();

    private PasswordMIssMatchException(){
        super(ErrorCode.PASSWORD_MISS_MATCH);
    }

}
