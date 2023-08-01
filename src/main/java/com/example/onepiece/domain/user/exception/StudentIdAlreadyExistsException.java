package com.example.onepiece.domain.user.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class StudentIdAlreadyExistsException extends CustomException {

    public static final CustomException EXCEPTION = new StudentIdAlreadyExistsException();

    private StudentIdAlreadyExistsException(){
        super(ErrorCode.STUDENTID_ALREADY_EXISTS);
    }
}
