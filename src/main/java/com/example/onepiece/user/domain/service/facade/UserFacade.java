package com.example.onepiece.user.domain.service.facade;

import com.example.onepiece.user.domain.entity.User;
import com.example.onepiece.user.domain.repository.UserRepository;
import com.example.onepiece.user.global.security.error.ErrorCode;
import com.example.onepiece.user.global.security.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
