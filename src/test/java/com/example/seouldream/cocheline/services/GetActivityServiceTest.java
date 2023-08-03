package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class GetActivityServiceTest {
  private ActivityRepository activityRepository;
  private UserRepository userRepository;
  private GetActivityService getActivityService;

  @BeforeEach
  void setUp() {
    activityRepository = mock(ActivityRepository.class);
    userRepository = mock(UserRepository.class);
    getActivityService = new GetActivityService(activityRepository,userRepository);
  }

  @Test
  void activity() {
    given(userRepository.findById(any())).willReturn(Optional.of(User.fake("김명훈")));
    given(activityRepository.findById(any())).willReturn(Optional.of(Activity.fake()));

    ActivityDto activityDto = getActivityService.activity(1L);

    verify(activityRepository,times(2)).findById(1L);

    assertThat(activityDto.getTitle()).isEqualTo("타이틀");
  }
}