package com.example.onepiece.domain.feed.service;


import com.amazonaws.services.kms.model.NotFoundException;
import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.feed.domain.repository.FeedRepository;
import com.example.onepiece.domain.feed.presentation.dto.response.CreateFeedResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.infra.s3.service.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    @Transactional
    public CreateFeedResponse createBoard(String place, Integer groupId, MultipartFile feedImage) {

        User currentUser = userFacade.getCurrentUser();

        if (!groupId.equals(currentUser.getGrade()) && !groupId.equals(currentUser.getClassNumber())) {
            throw new IllegalArgumentException("group not found");
        }

        Feed feed = feedRepository.save(
                Feed.builder()
                        .user(currentUser)
                        .groupId(groupId)
                        .starCounts(0)
                        .place(place)
                        .build()
        );

        String feedImageUrl = s3Facade.uploadImage(feedImage);
        feed.imageUpload(feedImageUrl);

        return new CreateFeedResponse(feed.getId());
    }

}
