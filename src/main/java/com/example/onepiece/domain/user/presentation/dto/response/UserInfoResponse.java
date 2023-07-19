package com.example.onepiece.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
public class UserInfoResponse {

    private String nickname;
    private List<String> profileImage;

}
