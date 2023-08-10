package com.example.onepiece.domain.board.service;

import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.response.BoardResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardReadService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public List<BoardResponse> findBoard() {

        User currentUser = userFacade.getCurrentUser();

        return boardRepository.findAll()
                .stream()
                .map(board -> new BoardResponse(board.getId(), board.getPlace(), board.))
    }
}
