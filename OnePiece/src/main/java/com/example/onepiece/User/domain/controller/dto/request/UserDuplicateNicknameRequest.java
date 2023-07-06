package com.example.onepiece.User.domain.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserDuplicateNicknameRequest {
    private String nickname;
}
