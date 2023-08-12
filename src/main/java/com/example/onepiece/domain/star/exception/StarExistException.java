package com.example.onepiece.domain.star.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class StarExistException extends CustomException{

    public static final CustomException EXCEPTION = new StarExistException();

    private StarExistException() {
        super(ErrorCode.STAR_EXIST);
    }
}
