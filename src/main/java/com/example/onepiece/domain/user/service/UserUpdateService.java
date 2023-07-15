package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.domain.repository.UserRepository;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final UserFacade userFacade;

    @Transactional
    public void userProfileUpdate(UserUpdateRequest request) {

        User user = userFacade.getCurrentUser();

        if (request.getNickname() != null){
            user.setNickname(request.getNickname());
        }

        if (request.getProfileImage() != null){
            user.setProfileImage(request.getProfileImage());
        }
    }
}
