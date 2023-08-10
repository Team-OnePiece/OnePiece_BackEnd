package com.example.onepiece.domain.tag.presentation;

import com.example.onepiece.domain.tag.service.TagCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagCreateService tagCreateService;

    @PostMapping
    public void createTag(@RequestParam(value = "tag") @NotNull @Size(min = 1, max = 5) String tag) {
        tagCreateService.tagCreate(tag);
    }
}
