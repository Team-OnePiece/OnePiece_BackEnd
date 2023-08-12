package com.example.onepiece.domain.board.service;

import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.response.QueryBoardResponse;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryBoardService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public List<QueryBoardResponse> findAllBoards() {

        return boardRepository.findAll()
                .stream()
                .map(QueryBoardResponse::new)
                .collect(Collectors.toList());
    }
}
