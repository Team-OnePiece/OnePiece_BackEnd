package com.example.onepiece.domain.user.presentation.dto.response;

import com.example.onepiece.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserInfoResponse {

    private String nickname;
    private String profileImageUrl;

    public static QueryUserInfoResponse of(User user) {

        return QueryUserInfoResponse.builder()
                .nickname(user.getNickname())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
    }
}
