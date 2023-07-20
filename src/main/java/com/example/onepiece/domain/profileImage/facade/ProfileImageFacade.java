package com.example.onepiece.domain.profileImage.facade;

import com.example.onepiece.domain.profileImage.domain.ProfileImage;
import com.example.onepiece.domain.profileImage.domain.repository.ProfileImageRepository;
import com.example.onepiece.infra.s3.exception.ImageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfileImageFacade {

    private final ProfileImageRepository profileImageRepository;

    public ProfileImage getCurrentProfileImage() {
        String profileImageUrl = SecurityContextHolder.getContext().getAuthentication().getName();
        return getProfileImageByProfileImageUrl(profileImageUrl);
    }


    public ProfileImage getProfileImageByProfileImageUrl(String profileImageUrl) {
        return profileImageRepository.findByProfileImageUrl(profileImageUrl)
                .orElseThrow(() -> ImageNotFoundException.EXCEPTION);
    }
}
