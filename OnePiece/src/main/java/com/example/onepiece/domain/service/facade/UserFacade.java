package com.example.onepiece.domain.service.facade;

import com.example.onepiece.domain.entity.User;
import com.example.onepiece.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("계정이 없습니다"));
    }

    public boolean existsByUserId(String userId){
    if(userRepository.existsByUserId(userId)){
            throw new  IllegalArgumentException("이미 사용하는 아이디 입니다");
        }else return true;
    }

    public boolean existsByNickname(String nickname){
        if (userRepository.existsByNickname(nickname)){
            throw new IllegalArgumentException("이미 사용하고 있는 별명 입니다");
        }
        else return true;
    }
}

