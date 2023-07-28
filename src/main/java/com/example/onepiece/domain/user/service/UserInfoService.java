package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserFacade userFacade;

    public UserInfoResponse userInfo(){

        return UserInfoResponse.of(userFacade.getCurrentUser());
    }
}
