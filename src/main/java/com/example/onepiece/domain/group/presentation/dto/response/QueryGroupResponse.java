package com.example.onepiece.domain.group.presentation.dto.response;

import com.example.onepiece.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryGroupResponse {

    private Integer grade;
    private Integer classNumber;

    public QueryGroupResponse (User user) {
        this.grade = user.getGrade();
        this.classNumber = user.getClassNumber();
    }
}
