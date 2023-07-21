package com.example.onepiece.domain.profileImage.presentation;

import com.example.onepiece.domain.profileImage.presentation.dto.response.ProfileImageResponse;
import com.example.onepiece.domain.profileImage.service.ProfileImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ProfileImageController {

    private final ProfileImageUploadService profileImageUploadService;

    @PostMapping
    public ProfileImageResponse upload(@RequestPart(required = false, value = "image") MultipartFile image) {
        return profileImageUploadService.upload(image);
    }
}
