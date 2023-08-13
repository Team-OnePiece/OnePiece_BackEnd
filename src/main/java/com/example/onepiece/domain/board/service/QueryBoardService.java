package com.example.onepiece.domain.board.service;

import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.response.QueryBoardResponse;
import com.example.onepiece.domain.tag.domain.Tag;
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
                .map(this::queryBoardResponse)
                .collect(Collectors.toList());
    }

    private QueryBoardResponse queryBoardResponse(Board board) {
        return QueryBoardResponse.builder()
                .id(board.getId())
                .boardImageUrl(board.getBoardImageUrl())
                .place(board.getPlace())
                .createAt(board.getCreatedAt())
                .nickname(board.getUser().getNickname())
                .grade(board.getUser().getGrade())
                .classNumber(board.getUser().getClassNumber())
                .number(board.getUser().getNumber())
                .profileImageUrl(board.getUser().getProfileImageUrl())
                .tags(board.getTags().stream().map(Tag::getTag).collect(Collectors.toList()))
                .build();

    }
}