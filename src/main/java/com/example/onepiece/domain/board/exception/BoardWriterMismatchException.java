package com.example.onepiece.domain.board.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.BusinessException;

public class BoardWriterMismatchException extends BusinessException {
    public static final BusinessException EXCEPTION = new BoardWriterMismatchException();
    public BoardWriterMismatchException(){
        super(ErrorCode.BOARD_WRITER_MISMATCH);
    }
}
