package com.example.onepiece.domain.star.presentation.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StarResponse {

    private Integer starCounts;
    private boolean star;
}
