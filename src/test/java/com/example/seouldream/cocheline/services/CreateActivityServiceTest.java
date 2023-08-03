package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateActivityServiceTest {
  private ActivityRepository activityRepository;
  private UserRepository userRepository;
  private CreateActivityService createActivityService;

  @BeforeEach
  void setUp() {
    activityRepository = mock(ActivityRepository.class);
    userRepository = mock(UserRepository.class);
    createActivityService = new CreateActivityService(activityRepository,userRepository);
  }

  @Test
  void create() {
    given(userRepository.findById(any())).willReturn(Optional.of(User.fake("김명훈")));
    given(activityRepository.save(any())).willReturn(
        Activity.fake()
    );

    ActivityDto activityDto = createActivityService.createActivity(ActivityRegistrationDto.fake(), 1L);

    verify(activityRepository).save(any());

    assertThat(activityDto.getContent()).isEqualTo("컨텐트");
  }
}