package com.example.onepiece.domain.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserDuplicateNicknameRequest {
    private String nickname;
}
