package com.example.onepiece.domain.user.presentation;

import com.example.onepiece.domain.user.service.ProfileImageUploadService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ProfileImageController {

    private final ProfileImageUploadService profileImageUploadService;

    @Operation(summary = "프로필 이미지 업로드")
    @PostMapping
    public void upload(@RequestPart(required = false, value = "image") MultipartFile image) {
         profileImageUploadService.upload(image);
    }
}
