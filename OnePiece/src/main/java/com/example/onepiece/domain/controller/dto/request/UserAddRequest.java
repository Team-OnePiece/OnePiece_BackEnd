package com.example.onepiece.domain.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserAddRequest {

    private String userId;

    private String userPassword;

    private String nickname;

    private String profile;

    private Integer classNumber;

    private Integer studentNumber;
}
