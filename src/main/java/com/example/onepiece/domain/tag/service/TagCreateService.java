package com.example.onepiece.domain.tag.service;

import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.facade.BoardFacade;
import com.example.onepiece.domain.tag.domain.Tag;
import com.example.onepiece.domain.tag.domain.repository.TagRepository;
import com.example.onepiece.domain.tag.exception.TagGenerationCountExceededException;
import com.example.onepiece.domain.tag.presentation.dto.request.TagCreateRequest;
import com.example.onepiece.domain.tag.presentation.dto.response.TagIdResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TagCreateService {

    private final TagRepository tagRepository;
    private final UserFacade userFacade;
    private final BoardFacade boardFacade;

    @Transactional
    public TagIdResponse tagCreate(TagCreateRequest request, Long boardId) {

        User user = userFacade.getCurrentUser();
        Board board = boardFacade.getBoard(boardId);

        if (board.getTags().size() >= 6) {
            throw TagGenerationCountExceededException.EXCEPTION;
        }

        Tag tag = tagRepository.save(
                Tag.builder()
                        .tag(request.getTag())
                        .user(user)
                        .board(board)
                        .build());

        return new TagIdResponse(tag.getId());
    }
}
