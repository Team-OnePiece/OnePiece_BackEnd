package com.example.onepiece.domain.board.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class BoardNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new BoardNotFoundException();
    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
