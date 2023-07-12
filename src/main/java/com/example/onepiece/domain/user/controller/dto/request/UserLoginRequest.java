package com.example.onepiece.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRequest {

    private String userId;

    private String userPassword;
}
