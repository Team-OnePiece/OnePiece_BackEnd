package com.example.onepiece.user.global.error.exception;


import com.example.onepiece.user.global.error.ErrorCode;

public class ExpiredTokenException extends CustomException{

    public static final CustomException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException(){
        super(ErrorCode.JWT_EXPIRED);
    }
}
