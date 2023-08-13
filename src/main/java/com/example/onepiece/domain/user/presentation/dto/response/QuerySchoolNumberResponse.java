package com.example.onepiece.domain.user.presentation.dto.response;

import com.example.onepiece.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuerySchoolNumberResponse {

    private Integer grade;
    private Integer classNumber;

    public QuerySchoolNumberResponse (User user) {
        this.grade = user.getGrade();
        this.classNumber = user.getClassNumber();
    }
}
