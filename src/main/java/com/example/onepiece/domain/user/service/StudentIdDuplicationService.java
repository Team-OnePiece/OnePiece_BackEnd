package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.repository.UserRepository;
import com.example.onepiece.domain.user.exception.StudentIdAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentIdDuplicationService {

    private final UserRepository userRepository;

    public void studentIdDuplicate(Integer grade, Integer classNumber, Integer number) {
        if (userRepository.existsByGradeAndClassNumberAndNumber(grade, classNumber, number)) {
            throw StudentIdAlreadyExistsException.EXCEPTION;
        }
    }
}
