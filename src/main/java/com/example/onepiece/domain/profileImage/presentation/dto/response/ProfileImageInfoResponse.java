package com.example.onepiece.domain.profileImage.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProfileImageInfoResponse {

    private final List<String> proFileImageUrl;

    public ProfileImageInfoResponse(List<String> proFileImageUrl){
        this.proFileImageUrl = proFileImageUrl;
    }

}
