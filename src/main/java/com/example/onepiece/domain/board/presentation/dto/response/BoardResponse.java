package com.example.onepiece.domain.board.presentation.dto.response;

import com.example.onepiece.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BoardResponse {

    private Long id;
    private String place;
    private String boardImageUrl;
    private LocalDate createAt;
    private User writer;
}