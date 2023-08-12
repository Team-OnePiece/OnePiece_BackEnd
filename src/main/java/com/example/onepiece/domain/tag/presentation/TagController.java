package com.example.onepiece.domain.tag.presentation;

import com.example.onepiece.domain.tag.presentation.dto.request.TagCreateRequest;
import com.example.onepiece.domain.tag.presentation.dto.response.TagIdResponse;
import com.example.onepiece.domain.tag.presentation.dto.response.TagMyListResponse;
import com.example.onepiece.domain.tag.service.TagCreateService;
import com.example.onepiece.domain.tag.service.TagDeleteService;
import com.example.onepiece.domain.tag.service.TagMyListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagCreateService tagCreateService;
    private final TagDeleteService tagDeleteService;
    private final TagMyListService tagMyListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{boardId}")
    public TagIdResponse createTag(@RequestBody @Valid TagCreateRequest request, @PathVariable(value = "boardId") Long boardId) {
      return tagCreateService.tagCreate(request, boardId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/remove/{tagId}")
    public void deleteTag(@PathVariable Long tagId) {
        tagDeleteService.tagDelete(tagId);
    }

    @GetMapping("/my/list")
    public List<TagMyListResponse>myListTag() {
        return tagMyListService.tagMyList();
    }
}
