package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

class GetActivityCommentsServiceTest {
  private ActivityCommentRepository activityCommentRepository;

  private GetActivityCommentsService getActivityCommentsService;

  private UserRepository userRepository;

  @BeforeEach
  void setUp() {
    activityCommentRepository =  mock(ActivityCommentRepository.class);
    userRepository = mock(UserRepository.class);
   getActivityCommentsService = new GetActivityCommentsService(activityCommentRepository,userRepository);
  }

  @Test
  void list() {
    given(userRepository.findById(any())).willReturn(Optional.of(User.fake("김명훈")));
    given(activityCommentRepository.findAllByActivityId(any()))
        .willReturn(List.of(ActivityComment.fake1(),ActivityComment.fake2()));

    ActivityCommentsDto activityComments = getActivityCommentsService.comments(1L);

    verify(activityCommentRepository).findAllByActivityId(any());

  }
}