package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.response.QueryUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryUserInfoService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryUserInfoResponse userInfo() {
        return new QueryUserInfoResponse(userFacade.getCurrentUser());
    }
}
