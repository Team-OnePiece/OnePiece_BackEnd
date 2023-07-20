package com.example.onepiece.global.error.exception;


import com.example.onepiece.global.error.ErrorCode;

public class JwtExpiredException extends CustomException{

    public static final CustomException EXCEPTION = new JwtExpiredException();

    private JwtExpiredException(){
        super(ErrorCode.JWT_EXPIRED);
    }
}
