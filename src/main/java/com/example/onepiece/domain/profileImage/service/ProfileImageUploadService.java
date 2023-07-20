package com.example.onepiece.domain.profileImage.service;

import com.example.onepiece.domain.profileImage.presentation.dto.response.ProfileImageResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.infra.s3.service.S3Upload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileImageUploadService {

    private final UserFacade userFacade;
    private final S3Upload s3Upload;

    public ProfileImageResponse upload(List<MultipartFile> images) {

        User user = userFacade.getCurrentUser();

            List<String> profileImageUrl = images
                    .stream()
                    .map(s3Upload::uploadImage)
                    .collect(Collectors.toList());

            return new ProfileImageResponse(profileImageUrl);

    }
}
