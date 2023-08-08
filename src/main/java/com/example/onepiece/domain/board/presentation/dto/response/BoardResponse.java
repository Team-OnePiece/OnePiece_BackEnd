package com.example.onepiece.domain.board.presentation.dto.response;

import com.example.onepiece.domain.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor

public class BoardResponse {

    private Long id;

    private String place;

    private String image;

    public BoardResponse(Board board) {
        id = board.getId();
        place = board.getPlace();
        image = board.getImage();
    }
}
