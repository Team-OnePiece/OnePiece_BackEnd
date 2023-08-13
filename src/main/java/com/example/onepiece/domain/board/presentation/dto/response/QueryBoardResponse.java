package com.example.onepiece.domain.board.presentation.dto.response;

import com.example.onepiece.domain.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class QueryBoardResponse {

    private Long id;
    private String place;
    private String boardImageUrl;
    private LocalDate createAt;
    private String nickname;
    private String profileImageUrl;
    private List<String> tags;
    private Integer grade;
    private Integer classNumber;
    private Integer number;
}
