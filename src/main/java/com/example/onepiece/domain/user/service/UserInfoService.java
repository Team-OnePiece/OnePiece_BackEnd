package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.domain.repository.UserRepository;
import com.example.onepiece.domain.user.exception.UserNotFoundException;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public UserInfoResponse userInfo(){
        
        User currentUser = userFacade.getCurrentUser();
        Optional<User>user = userRepository.findByUserId(currentUser.getAccountId());

        if (!user.isPresent()){
            throw UserNotFoundException.EXCEPTION;
        }
        else {
            return new UserInfoResponse(user.get().getNickname());
        }
    }
}
