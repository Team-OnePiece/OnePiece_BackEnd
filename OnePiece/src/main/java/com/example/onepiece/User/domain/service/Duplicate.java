package com.example.onepiece.User.domain.service;

import com.example.onepiece.User.domain.controller.dto.request.UserDuplicateNicknameRequest;
import com.example.onepiece.User.domain.controller.dto.request.UserDuplicateUserIdRequest;
import com.example.onepiece.User.domain.service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Duplicate {

    private final UserFacade userFacade;

    public Boolean idDuplicate(UserDuplicateUserIdRequest request){
        return userFacade.existsByUserId(request.getUserId());
    }

    public Boolean nicknameDuplicate(UserDuplicateNicknameRequest request){
       return userFacade.existsByNickname(request.getNickname());
    }
}
