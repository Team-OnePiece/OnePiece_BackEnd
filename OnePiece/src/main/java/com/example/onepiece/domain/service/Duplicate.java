package com.example.onepiece.domain.service;

import com.example.onepiece.domain.controller.dto.request.UserDuplicateNicknameRequest;
import com.example.onepiece.domain.controller.dto.request.UserDuplicateUserIdRequest;
import com.example.onepiece.domain.service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Duplicate {

    private final UserFacade userFacade;

    public void idDuplicate(UserDuplicateUserIdRequest request){
        userFacade.existsByUserId(request.getUserId());
    }

    public void nicknameDuplicate(UserDuplicateNicknameRequest request){
        userFacade.existsByNickname(request.getNickname());
    }
}