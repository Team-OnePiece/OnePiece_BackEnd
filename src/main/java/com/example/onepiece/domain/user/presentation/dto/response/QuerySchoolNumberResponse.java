package com.example.onepiece.domain.user.presentation.dto.response;

import com.example.onepiece.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuerySchoolNumberResponse {

    private Integer grade;
    private Integer classNumber;

    public static QuerySchoolNumberResponse of(User user) {

        return QuerySchoolNumberResponse.builder()
                .grade(user.getGrade())
                .classNumber(user.getClassNumber())
                .build();
    }
}
