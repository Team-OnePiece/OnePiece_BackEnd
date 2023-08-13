package com.example.onepiece.domain.group.service;

import com.example.onepiece.domain.group.presentation.dto.response.QueryGroupResponse;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryGroupService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryGroupResponse queryGroup() {

        return new QueryGroupResponse(userFacade.getCurrentUser());
    }
}
