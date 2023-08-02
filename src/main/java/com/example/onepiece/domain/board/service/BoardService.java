package com.example.onepiece.domain.board.service;

import com.example.onepiece.domain.board.controller.dto.BoardController;
import com.example.onepiece.domain.board.controller.dto.request.BoardRequest;
import com.example.onepiece.domain.board.controller.dto.response.BoardIdResponse;
import com.example.onepiece.domain.board.controller.dto.response.BoardResponse;
import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.exception.BoardNotFoundException;
import com.example.onepiece.domain.board.exception.BoardWriterMismatchException;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public BoardIdResponse writeBoard(BoardRequest request) {
        User currentUser = userFacade.CurrentUser();
        Board board = boardRepository.save(
                Board.builder()
                        .user(currentUser)
                        .place(request.getPlace())
                        .image(request.getImage())
                        .build()
        );
        return new BoardIdResponse(board.getId());
    }

    public void deleteBoard(Long boardId) {
        User currentUser = userFacade.currentUser();
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);
        writerCheck(currentUser, board);
        boardRepository.deleteById(boardId);
    }

    public void writerCheck(User user, Board board) {
        if (board.getUser() != user) {
            throw BoardWriterMismatchException.EXCEPTION;
        }
    }

    public BoardResponse findBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);
        return new BoardResponse(board);
    }

    public List<BoardResponse> finaAllBoards() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList());

    }

    public List<BoardResponse> findMyBoards() {
        User currentUser = userFacade.currentUser();
        return boardRepository.findByUserId(currentUser.getId())
                .stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList());
    }
}
