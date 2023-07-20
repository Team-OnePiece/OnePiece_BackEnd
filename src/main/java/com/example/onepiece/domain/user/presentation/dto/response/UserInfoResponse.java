package com.example.onepiece.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponse {

    private String nickname;

    public UserInfoResponse(String nickname){
        this.nickname = nickname;
    }
}
