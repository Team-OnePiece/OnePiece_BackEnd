package com.example.onepiece.domain.feed.presentation.dto.response;

import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.tag.domain.Tag;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class QueryFeedResponse {

    private Long id;
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

    public static QueryFeedResponse queryFeedResponse(Feed feed) {
        return QueryFeedResponse.builder()
                .id(feed.getId())
                .boardImageUrl(feed.getBoardImageUrl())
                .place(feed.getPlace())
                .starCount(feed.getStarCounts())
                .createAt(feed.getCreatedAt())
                .nickname(feed.getUser().getNickname())
                .grade(feed.getUser().getGrade())
                .classNumber(feed.getUser().getClassNumber())
                .number(feed.getUser().getNumber())
                .profileImageUrl(feed.getUser().getProfileImageUrl())
                .tags(feed.getTags().stream().map(Tag::getTag).collect(Collectors.toList()))
                .build();

    }
}
