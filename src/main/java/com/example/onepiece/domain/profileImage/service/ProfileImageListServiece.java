package com.example.onepiece.domain.profileImage.service;

import com.example.onepiece.domain.profileImage.domain.ProfileImage;
import com.example.onepiece.domain.profileImage.facade.ProfileImageFacade;
import com.example.onepiece.domain.profileImage.presentation.dto.response.ProfileImageInfoResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class ProfileImageListServiece {

    private final UserFacade userFacade;
    private final ProfileImageFacade profileImageFacade;

    public ProfileImageInfoResponse profileList() {

        User user = userFacade.getCurrentUser();
        ProfileImage profileImage = profileImageFacade.getCurrentProfileImage();

        return ProfileImageInfoResponse.builder()
                .proFileImageUrl(Collections.singletonList(profileImage.getProfileImageUrl()))
                .build();
    }
}
