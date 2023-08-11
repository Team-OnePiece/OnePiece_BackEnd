package com.example.onepiece.domain.board.presentation.dto.response;

import com.example.onepiece.domain.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class QueryBoardResponse {

    private Long id;
    private String place;
    private String boardImageUrl;
    private LocalDate createAt;
    private String nickname;
    private String profileImageUrl;
    private Integer grade;
    private Integer classNumber;
    private Integer number;

    public QueryBoardResponse(Board board) {
        this.id = board.getId();
        this.place = board.getPlace();
        this.boardImageUrl = board.getBoardImageUrl();
        this.createAt = board.getCreatedAt();
        this.nickname = board.getUser().getNickname();
        this.profileImageUrl = board.getUser().getProfileImageUrl();
        this.grade = board.getUser().getGrade();
        this.classNumber = board.getUser().getClassNumber();
        this.number = board.getUser().getNumber();
    }

}