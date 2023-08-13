package com.example.onepiece.domain.feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class QueryFeedResponse {

    private Long feedId;
    private String place;
    private String boardImageUrl;
    private LocalDate createAt;
    private String nickname;
    private String profileImageUrl;
    private List<String> tags;
    private Integer grade;
    private Integer classNumber;
    private Integer number;
    private Integer starCount;
}
