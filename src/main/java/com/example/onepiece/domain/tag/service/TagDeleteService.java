package com.example.onepiece.domain.tag.service;

import com.example.onepiece.domain.tag.domain.repository.TagRepository;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TagDeleteService {

    private final UserFacade userFacade;
    private final TagRepository tagRepository;

    @Transactional
    public void tagDelete(Long id) {

        User user = userFacade.getCurrentUser();

        tagRepository.deleteById(id);
    }
}
