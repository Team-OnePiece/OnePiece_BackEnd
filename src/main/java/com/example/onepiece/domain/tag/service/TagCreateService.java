package com.example.onepiece.domain.tag.service;

import com.example.onepiece.domain.tag.domain.Tag;
import com.example.onepiece.domain.tag.domain.repository.TagRepository;
import com.example.onepiece.domain.tag.exception.TagGenerationCountExceededException;
import com.example.onepiece.domain.tag.presentation.dto.request.TagCreateRequest;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagCreateService {

    private final TagRepository tagRepository;
    private final UserFacade userFacade;

    @Transactional
    public void tagCreate(TagCreateRequest request) {

        User user = userFacade.getCurrentUser();
        List<Tag>userTags = tagRepository.findByUser(user);

        if (userTags.size() >= 6) {
            throw TagGenerationCountExceededException.EXCEPTION;
        }

        tagRepository.save(
                Tag.builder()
                        .user(user)
                        .tag(request.getTag())
                        .build());
    }
}
