package com.example.onepiece.domain.user.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class NicknameAlreadyExistsException extends CustomException {
    public static final CustomException EXCEPTION = new NicknameAlreadyExistsException();

    private NicknameAlreadyExistsException(){
        super(ErrorCode.NICKNAME_ALREADY_EXISTS);
    }
}
