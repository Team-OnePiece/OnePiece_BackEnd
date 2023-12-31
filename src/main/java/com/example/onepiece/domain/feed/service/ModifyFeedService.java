package com.example.onepiece.domain.feed.service;

import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.feed.exception.FeedWriterMismatchException;
import com.example.onepiece.domain.feed.facade.FeedFacade;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.infra.s3.service.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ModifyFeedService {

    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    @Transactional
    public void modifyFeed(Long feedId, String place, MultipartFile feedImage) {
        User currentUser = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        if (!currentUser.equals(feed.getUser())) {
            throw FeedWriterMismatchException.EXCEPTION;
        }

        String feedImageUrl = s3Facade.uploadImage(feedImage);
        feed.modifyPlaceAndBoardImageUrl(place, feedImageUrl);
    }
}
