package com.example.onepiece.domain.user.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class AccountIdAlreadyExistsException extends CustomException {
    public static final CustomException EXCEPTION = new AccountIdAlreadyExistsException();

    private AccountIdAlreadyExistsException(){
        super(ErrorCode.USERID_ALREADY_EXISTS);
    }
}
