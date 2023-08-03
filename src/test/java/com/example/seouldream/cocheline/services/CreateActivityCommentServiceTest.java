package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateActivityCommentServiceTest {
  private ActivityCommentRepository activityCommentRepository;
  private UserRepository userRepository;
  private CreateActivityCommentService createActivityCommentService;

  @BeforeEach
  void setUp() {
    activityCommentRepository = mock(ActivityCommentRepository.class);
    userRepository = mock(UserRepository.class);
    createActivityCommentService = new CreateActivityCommentService(
        activityCommentRepository,userRepository);
  }

  @Test
  void post() {
    given(userRepository.findById(any())).willReturn(Optional.of(User.fake("김명훈")));
    given(activityCommentRepository.save(any()))
        .willReturn(ActivityComment.fake1());

    createActivityCommentService.create(1L,1L,new ActivityCommentRegistrationDto("코멘트1"));

    verify(activityCommentRepository).save(any());

  }
}