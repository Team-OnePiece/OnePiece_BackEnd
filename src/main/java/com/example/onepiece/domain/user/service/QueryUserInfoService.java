package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.response.QueryUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryUserInfoService {

    private final UserFacade userFacade;

    public QueryUserInfoResponse userInfo(){

        return QueryUserInfoResponse.of(userFacade.getCurrentUser());
    }
}
