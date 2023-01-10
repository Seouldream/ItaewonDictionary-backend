package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

class CreatePracticeCommentServiceTest {
  private PracticeCommentRepository practiceCommentRepository;
  private CreatePracticeCommentService createPracticeCommentService;
  private UserRepository userRepository;

  @BeforeEach
  void setUp() {
    practiceCommentRepository = mock(PracticeCommentRepository.class);
    userRepository = mock(UserRepository.class);
    createPracticeCommentService = new CreatePracticeCommentService(practiceCommentRepository, userRepository);
  }

  @Test
  void post() {
    given(practiceCommentRepository.save(any()))
        .willReturn(PracticeComment.fake1());

    given(userRepository.findById(any()))
        .willReturn(Optional.of(User.fake("김명훈")));


    createPracticeCommentService.create(
        1L,
        1L,
        new PracticeCommentRegistrationDto("코멘트1"));

    verify(practiceCommentRepository).save(any());

  }
}