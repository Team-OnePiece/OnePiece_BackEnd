package com.example.onepiece.domain.service.facade;

import com.example.onepiece.domain.entity.User;
import com.example.onepiece.domain.repository.UserRepository;
import com.example.onepiece.global.security.error.ErrorCode;
import com.example.onepiece.global.security.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUserId(userId)
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

