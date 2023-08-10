package com.example.onepiece.domain.tag.presentation;

import com.example.onepiece.domain.tag.presentation.dto.request.TagCreateRequest;
import com.example.onepiece.domain.tag.service.TagCreateService;
import com.example.onepiece.domain.tag.service.TagDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagCreateService tagCreateService;
    private final TagDeleteService tagDeleteService;

    @PostMapping
    public void createTag(@RequestBody @Valid TagCreateRequest request) {
        tagCreateService.tagCreate(request);
    }

    @DeleteMapping("/remove/{tagId}")
    public void deleteTag(@PathVariable Long tagId) {
        tagDeleteService.tagDelete(tagId);
    }
}
