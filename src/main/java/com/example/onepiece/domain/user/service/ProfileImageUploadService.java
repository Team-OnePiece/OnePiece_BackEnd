package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.infra.s3.service.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProfileImageUploadService {

    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    @Transactional
    public String upload(MultipartFile profileImage) {
        User user = userFacade.getCurrentUser();

        String profileImageUrl = s3Facade.uploadImage(profileImage);

        user.profileUpload(profileImageUrl);

        return profileImageUrl;
    }
}
