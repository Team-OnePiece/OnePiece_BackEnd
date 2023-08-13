package com.example.onepiece.domain.star.presentation;


import com.example.onepiece.domain.star.presentation.dto.response.StarResponse;
import com.example.onepiece.domain.star.service.CreateStarService;
import com.example.onepiece.domain.star.service.RemoveStarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/star")
@RestController
public class StarController {

    private final CreateStarService createStarService;
    private final RemoveStarService removeStarService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feedId}/star")
    public StarResponse star(@PathVariable("feedId") Long feedId){
        return createStarService.createStar(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/{feedId}/delete-star")
    public StarResponse deleteStar(@PathVariable("feedId") Long feedId){
        return removeStarService.deleteStar(feedId);
    }
}
