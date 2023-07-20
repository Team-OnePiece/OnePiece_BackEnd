package com.example.onepiece.domain.profileImage.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProfileImageResponse {

    private final List<String> proFileImage;
}
