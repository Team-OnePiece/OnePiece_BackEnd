package com.example.onepiece.domain.group.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class GroupNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new GroupNotFoundException();

    private GroupNotFoundException {
        super(ErrorCode.GROUP_NOT_FOUND);
    }
}
