package com.example.onepiece.User.domain.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDuplicateNicknameRequest {
    private String nickname;
}
