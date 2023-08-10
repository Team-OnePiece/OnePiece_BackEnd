package com.example.onepiece.domain.tag.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class TagCreateRequest {

    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9@#$%\\W\\S]{1,5}$")
    private String tag;
}
