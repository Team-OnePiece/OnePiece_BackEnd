package com.example.onepiece.domain.star.presentation.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class StarResponse {

    private Integer starCounts;
    private boolean star;
}

