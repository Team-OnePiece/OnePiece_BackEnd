package com.example.onepiece.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NicknameDuplicateRequest {
    private String nickname;
}
