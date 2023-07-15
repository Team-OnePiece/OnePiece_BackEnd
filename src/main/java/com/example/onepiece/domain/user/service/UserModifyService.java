package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.domain.repository.UserRepository;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.presentation.dto.request.UserModifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserModifyService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void userModify(UserModifyRequest request){

        User user = userFacade.getCurrentUser();

        user.update(request.getNickname());
        userRepository.save(user);
    }
}
