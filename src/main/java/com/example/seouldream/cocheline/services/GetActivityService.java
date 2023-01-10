package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class GetActivityService {
  private ActivityRepository activityRepository;
  private UserRepository userRepository;

  public GetActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
    this.activityRepository = activityRepository;
    this.userRepository = userRepository;
  }

  public ActivityDto activity(Long id) {
    Activity activity = activityRepository.findById(id).orElseThrow(NoFoundActivityError::new);

    Optional<User> user = userRepository.findById(activity.getUserId());

    String name = user.orElseThrow(NoExistingUser::new).getName();

    return activityRepository.findById(id).orElseThrow().toDto(name);
  }
}
