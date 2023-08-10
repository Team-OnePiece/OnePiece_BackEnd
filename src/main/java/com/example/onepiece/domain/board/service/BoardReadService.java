package com.example.onepiece.domain.board.service;

import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.response.BoardResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardReadService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public List<BoardResponse> findAllBoards() {

        User currentUser = userFacade.getCurrentUser();

        return boardRepository.findAll()
                .stream()
                .map(board -> new BoardResponse(board.getId(), board.getPlace(), board.getBoardImageUrl(), board.getCreatedAt(), board.getUser()))
                .collect(Collectors.toList());
    }
}
