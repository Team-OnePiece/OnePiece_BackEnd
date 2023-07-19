package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.request.UserUpdateRequest;
import com.example.onepiece.infra.s3.service.S3Upload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final UserFacade userFacade;
    private final S3Upload s3Upload;

    @Transactional
    public void userProfileUpdate(UserUpdateRequest request) {

        User user = userFacade.getCurrentUser();

        if (request.getProfileImage() != null) {
            s3Upload.uploadImage(request.getProfileImage());
        }

        if (request.getNickname() != null) {
            user.profileUpdate(request.getNickname(), null);
        }
    }
}
