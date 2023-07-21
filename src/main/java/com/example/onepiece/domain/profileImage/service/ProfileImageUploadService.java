package com.example.onepiece.domain.profileImage.service;

import com.example.onepiece.domain.profileImage.presentation.dto.response.ProfileImageResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.infra.s3.service.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileImageUploadService {

    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    public ProfileImageResponse upload(MultipartFile images) {
        User user = userFacade.getCurrentUser();
        if (images == null) {
            return new ProfileImageResponse("https://i.pinimg.com/736x/e3/1a/b4/e31ab423d046dd57f557d9dfd8700b76.jpg");
        }

        return new ProfileImageResponse(s3Facade.uploadImage(images));
    }
}
