package com.example.onepiece.domain.board.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.BusinessException;

public class BoardNotFoundException extends BusinessException{
    public static final BusinessException EXCEPTION = new BoardNotFoundException();
    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
