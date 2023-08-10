package com.example.onepiece.domain.board.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class BoardCreateRequest {

    @NotNull
    private String place;
}