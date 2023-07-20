package com.example.onepiece.domain.profileImage.presentation;

import com.example.onepiece.domain.profileImage.presentation.dto.response.ProfileImageInfoResponse;
import com.example.onepiece.domain.profileImage.presentation.dto.response.ProfileImageResponse;
import com.example.onepiece.domain.profileImage.service.ProfileImageListServiece;
import com.example.onepiece.domain.profileImage.service.ProfileImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ProfileImageController {

    private final ProfileImageListServiece profileImageListServiece;
    private final ProfileImageUploadService profileImageUploadService;

    @PatchMapping
    public ProfileImageResponse upload(@RequestPart List<MultipartFile> profileImageUrl) {
        return profileImageUploadService.upload(profileImageUrl);
    }

    @GetMapping("/info")
    public ProfileImageInfoResponse info() {
        return profileImageListServiece.profileList();
    }
}
