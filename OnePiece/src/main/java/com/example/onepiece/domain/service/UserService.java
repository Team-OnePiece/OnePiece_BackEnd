package com.example.onepiece.domain.service;

import com.example.onepiece.domain.controller.dto.request.UserAddRequest;
import com.example.onepiece.domain.entity.User;
import com.example.onepiece.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void addUser(UserAddRequest request){
        String userId = request.getUserId();
        Optional<User> user = userRepository.findByUserId(userId);
        if(user.isEmpty()){
            userRepository.save(
                    User.builder()
                            .userId(request.getUserId())
                            .userPassword(request.getUserPassword())
                            .nickname(request.getNickname())
                            .profile(request.getProfile())
                            .classNumber(request.getClassNumber())
                            .studentNumber(request.getStudentNumber())
                            .build());
        }
        else {
            throw new IllegalArgumentException("중복된 아이디");
        }
    }
}
