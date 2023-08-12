package com.example.onepiece.domain.star.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class RemoveStarExistException extends CustomException {

    public static final CustomException EXCEPTION = new RemoveStarExistException();

    private RemoveStarExistException() {
        super(ErrorCode.REMOVE_STAR_EXIST);
    }
}
