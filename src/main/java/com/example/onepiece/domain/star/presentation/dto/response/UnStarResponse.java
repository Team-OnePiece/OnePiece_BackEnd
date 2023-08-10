package com.example.onepiece.domain.star.presentation.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnStarResponse {

    private Integer UnStarCounts;
    private boolean UnStar;
}
