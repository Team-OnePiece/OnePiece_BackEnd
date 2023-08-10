package com.example.onepiece.domain.board.presentation.dto.response;

import com.example.onepiece.domain.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BoardAllResponse {

    private Long id;
    private String place;
    private String boardImageUrl;
    private LocalDate createAt;
    private String nickname;

    public BoardAllResponse(Board board) {
        this.id = board.getId();
        this.place = board.getPlace();
        this.boardImageUrl = board.getBoardImageUrl();
        this.createAt = board.getCreatedAt();
        this.nickname = board.getUser().getNickname();
    }

}