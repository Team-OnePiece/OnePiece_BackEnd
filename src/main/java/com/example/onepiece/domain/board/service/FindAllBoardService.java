package com.example.onepiece.domain.board.service;

import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.response.BoardReadResponse;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllBoardService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public List<BoardReadResponse> findAllBoards() {

        return boardRepository.findAll()
                .stream()
                .map(BoardReadResponse::new)
                .collect(Collectors.toList());
    }
}
