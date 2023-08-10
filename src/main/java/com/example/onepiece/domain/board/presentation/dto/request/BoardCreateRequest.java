package com.example.onepiece.domain.board.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class BoardCreateRequest {

    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9@#$%\\W\\S]{1,10}$")
    @NotNull
    private String place;

}
