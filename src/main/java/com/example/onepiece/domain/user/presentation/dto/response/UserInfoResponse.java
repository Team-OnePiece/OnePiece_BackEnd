package com.example.onepiece.domain.user.presentation.dto.response;

import com.example.onepiece.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserInfoResponse {

    private String nickname;
    private String profileImageUrl;

    public static UserInfoResponse of(User user) {

        return UserInfoResponse.builder()
                .nickname(user.getNickname())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
    }
}
