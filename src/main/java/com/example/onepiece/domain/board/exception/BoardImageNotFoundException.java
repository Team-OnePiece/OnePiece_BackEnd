package com.example.onepiece.domain.board.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class BoardImageNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new BoardImageNotFoundException();

    public BoardImageNotFoundException() {
        super(ErrorCode.BOARD_IMAGE_NOT_FOUND);
    }
}
