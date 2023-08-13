package com.example.onepiece.domain.user.presentation.dto.response;

import com.example.onepiece.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryUserInfoResponse {

    private String nickname;
    private String profileImageUrl;

    public QueryUserInfoResponse(User user) {
        this.nickname = user.getNickname();
        this.profileImageUrl = user.getProfileImageUrl();
    }
}
