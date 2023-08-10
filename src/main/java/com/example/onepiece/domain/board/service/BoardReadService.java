package com.example.onepiece.domain.board.service;

import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.response.BoardAllResponse;
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

    public List<BoardAllResponse> findAllBoards() {

        return boardRepository.findAll()
                .stream()
                .map(BoardAllResponse::new)
                .collect(Collectors.toList());
    }
}
