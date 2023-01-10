package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetActivitiesServiceTest {
  private ActivityRepository activityRepository;
  private GetActivitiesService getActivitiesService;
  private UserRepository userRepository;

  @BeforeEach
  void setup() {
    activityRepository = mock(ActivityRepository.class);
    userRepository = mock(UserRepository.class);
    getActivitiesService = new GetActivitiesService(activityRepository,userRepository);
  }

  @Test
  void activityList() {

    List<Activity> activities = List.of(Activity.fake(),Activity.fake2());

    PageImpl<Activity> activityPages = new PageImpl<>(activities);

    given(userRepository.findById(any())).willReturn(Optional.of(User.fake("김명훈")));

    given(activityRepository.findAll(any(Pageable.class))).willReturn(
      activityPages
    );

    getActivitiesService.list(1);

    verify(activityRepository).findAll(any(Pageable.class));
  }
}
