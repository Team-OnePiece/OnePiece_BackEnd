package com.example.onepiece.domain.star.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class RemoveUnStarExistException extends CustomException {

    public static final CustomException EXCEPTION = new RemoveUnStarExistException();

    private RemoveUnStarExistException() {
        super(ErrorCode.REMOVE_UNSTAR_EXIST);
    }
}
