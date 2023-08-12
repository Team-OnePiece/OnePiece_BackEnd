package com.example.onepiece.domain.board.service;

import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.exception.BoardWriterMismatchException;
import com.example.onepiece.domain.board.facade.BoardFacade;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteBoardService {

    private final BoardFacade boardFacade;
    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    @Transactional
    public void deleteBoard(Long boardId) {

        User currentUser = userFacade.getCurrentUser();
        Board board = boardFacade.getBoard(boardId);

        if (!currentUser.equals(board.getUser())) {
            throw BoardWriterMismatchException.EXCEPTION;
        }
        
        boardRepository.deleteById(boardId);
    }
}
