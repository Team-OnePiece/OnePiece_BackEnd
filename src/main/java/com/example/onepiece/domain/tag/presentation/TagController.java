package com.example.onepiece.domain.tag.presentation;

import com.example.onepiece.domain.tag.presentation.dto.request.TagCreateRequest;
import com.example.onepiece.domain.tag.presentation.dto.response.TagIdResponse;
import com.example.onepiece.domain.tag.service.TagCreateService;
import com.example.onepiece.domain.tag.service.TagDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagCreateService tagCreateService;
    private final TagDeleteService tagDeleteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feedId}")
    public TagIdResponse createTag(@RequestBody @Valid TagCreateRequest request, @PathVariable(value = "feedId") Long feedId) {
      return tagCreateService.tagCreate(request, feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feedId}")
    public void deleteTag(@PathVariable Long feedId) {
        tagDeleteService.tagDelete(feedId);
    }
}
