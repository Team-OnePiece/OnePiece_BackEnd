package com.example.onepiece.domain.tag.service;

import com.example.onepiece.domain.tag.domain.Tag;
import com.example.onepiece.domain.tag.domain.repository.TagRepository;
import com.example.onepiece.domain.tag.presentation.dto.response.TagMyListResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagMyListService {

    private final UserFacade userFacade;
    private final TagRepository tagRepository;

    public List<TagMyListResponse> tagMyList() {

        User user = userFacade.getCurrentUser();
        List<Tag> userTags = tagRepository.findByUser(user);

        return userTags.stream()
                .map(tag -> new TagMyListResponse(tag.getTag(), tag.getBoard().getId()))
                .collect(Collectors.toList());
    }
}
