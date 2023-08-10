package com.example.onepiece.domain.star.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class UnStarExistException extends CustomException{

    public static final CustomException EXCEPTION = new UnStarExistException();

    private UnStarExistException() {
        super(ErrorCode.UNSTAR_EXIST);
    }
}
