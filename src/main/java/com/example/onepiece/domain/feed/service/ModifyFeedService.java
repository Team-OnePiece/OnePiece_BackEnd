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
    public void modifyBoard(Long boardId, String place, MultipartFile boardImage) {
        User currentUser = userFacade.getCurrentUser();
        Feed board = feedFacade.getBoard(boardId);

        if (!currentUser.equals(board.getUser())) {
            throw FeedWriterMismatchException.EXCEPTION;
        }

        String boardImageUrl = s3Facade.uploadImage(boardImage);
        board.modifyPlaceAndBoardImageUrl(place, boardImageUrl);
    }
}
