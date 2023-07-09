package com.example.onepiece.user.global.error.exception;

import com.example.onepiece.user.global.error.ErrorCode;

public class UserNotFoundException extends CustomException{

    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
