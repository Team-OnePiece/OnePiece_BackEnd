package com.example.onepiece.domain.board.controller.dto.response;

import com.example.onepiece.domain.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BoardResponse {

    private Long id;

    private String nickname;

    private String place;

    private String image;

    public BoardResponse(Board board) {
        id = board.getId();
        nickname = board.getUser().getNickname();
        place = board.getPlace();
        image = board.getImage();
    }
}
