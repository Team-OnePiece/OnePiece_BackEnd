package com.example.onepiece.domain.user.presentation.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoResponse {

    private String nickname;

    public UserInfoResponse(String nickname){
        this.nickname = nickname;
    }
}
