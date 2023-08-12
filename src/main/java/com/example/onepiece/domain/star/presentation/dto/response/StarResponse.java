package com.example.onepiece.domain.star.presentation.dto.response;

import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StarResponse {

    private Integer starCounts;
    private boolean star;
}

