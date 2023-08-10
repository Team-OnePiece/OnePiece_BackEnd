package com.example.onepiece.domain.board.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class RequestBoard {

    @NotNull
    private String place;

    @NotNull
    private String boardImageUrl;
}