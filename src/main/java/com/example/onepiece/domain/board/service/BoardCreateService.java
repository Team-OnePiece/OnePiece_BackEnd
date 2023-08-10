package com.example.onepiece.domain.board.service;


import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.request.BoardRequest;
import com.example.onepiece.domain.board.presentation.dto.response.BoardIdResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardCreateService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public BoardIdResponse writeBoard(BoardRequest request) {
        User currentUser = userFacade.getCurrentUser();
        Board board = boardRepository.save(
                Board.builder()
                        .user(currentUser)
                        .place(request.getPlace())
                        .image(request.getImage())
                        .build()
        );
        return new BoardIdResponse(board.getId());
    }

}