package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.request.UserModifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserModifyService {

    private final UserFacade userFacade;

    public void userModify(UserModifyRequest request){

        User user = userFacade.getCurrentUser();

        user.modify(request.getNickname());
    }
}
