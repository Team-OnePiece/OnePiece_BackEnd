package com.example.onepiece.domain.board.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class BoardWriterMismatchException extends CustomException {

    public static final CustomException EXCEPTION = new BoardWriterMismatchException();

    public BoardWriterMismatchException() {
        super(ErrorCode.BOARD_WRITER_MISMATCH);
    }
}
