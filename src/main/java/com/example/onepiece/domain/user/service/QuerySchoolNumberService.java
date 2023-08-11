package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.response.QuerySchoolNumberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuerySchoolNumberService {

    private final UserFacade userFacade;

    public QuerySchoolNumberResponse querySchoolNumber() {

        return QuerySchoolNumberResponse.of(userFacade.getCurrentUser());
    }
}
