package com.example.onepiece.User.domain.service.facade;

import com.example.onepiece.User.domain.entity.User;
import com.example.onepiece.User.domain.repository.UserRepository;
import com.example.onepiece.User.global.security.error.ErrorCode;
import com.example.onepiece.User.global.security.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }

    public boolean existsByUserId(String userId){
    if(userRepository.existsByUserId(userId)){
            throw new CustomException(ErrorCode.USER_ALREADY_EXISTS);
        }
    else return true;
    }

    public boolean existsByNickname(String nickname){
        if (userRepository.existsByNickname(nickname)){
            throw new CustomException(ErrorCode.NICKNAME_ALREADY_EXISTS);
        }
        else return true;
    }
}

