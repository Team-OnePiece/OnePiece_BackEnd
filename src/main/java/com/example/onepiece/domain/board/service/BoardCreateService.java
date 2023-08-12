package com.example.onepiece.domain.board.service;


import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.response.BoardCreateResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.infra.s3.service.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardCreateService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    @Transactional
    public BoardCreateResponse writeBoard(String place) {

        User currentUser = userFacade.getCurrentUser();
        Board board = boardRepository.save(
                Board.builder()
                        .user(currentUser)
                        .starCounts(0)
                        .place(place)
                        .build()
        );

        return new BoardCreateResponse(board.getId());
    }

}
