package com.example.onepiece.domain.board.presentation.dto.response;

import com.example.onepiece.domain.board.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardResponse {

    private final String place;
    private final String boardImageUrl;

    public static BoardResponse of(Board board) {

        return BoardResponse.builder()
                .place(board.getPlace())
                .boardImageUrl(board.getBoardImageUrl())
                .build();
    }
}
