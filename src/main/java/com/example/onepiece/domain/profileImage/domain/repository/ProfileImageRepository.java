package com.example.onepiece.domain.profileImage.domain.repository;


import com.example.onepiece.domain.profileImage.domain.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {

    Optional<ProfileImage> findByProfileImageUrl(String profileImageUrl);
}
