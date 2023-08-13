package com.example.onepiece.domain.group.presentation;

import com.example.onepiece.domain.group.presentation.dto.response.QueryGroupResponse;
import com.example.onepiece.domain.group.service.QueryGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("group")
@RequiredArgsConstructor
public class GroupController {

    private final QueryGroupService queryGroupService;

    @PostMapping
    public QueryGroupResponse groupQuery() {
        return queryGroupService.queryGroup();
    }
}
