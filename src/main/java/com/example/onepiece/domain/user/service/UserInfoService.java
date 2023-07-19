package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.domain.repository.UserRepository;
import com.example.onepiece.domain.user.exception.UserNotFoundException;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public UserInfoResponse userInfo(){
        
        User user = userFacade.getCurrentUser();

        return UserInfoResponse.builder()
                .nickname(user.getNickname())
                .profileImage(profileImage(user))
                .build();
    }

    private List<String> profileImage(User user){

        return userRepository.findByUser(user)
                .stream()
                .map(User::getProfileImage)
                .toList();
    }
}
