package com.example.onepiece.domain.star.presentation.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnStarResponse {

    private Integer unStarCounts;
    private boolean unStar;
}
