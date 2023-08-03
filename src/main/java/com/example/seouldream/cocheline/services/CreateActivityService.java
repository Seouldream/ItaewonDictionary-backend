package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class CreateActivityService {
  private ActivityRepository activityRepository;
  private UserRepository userRepository;

  public CreateActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
    this.activityRepository = activityRepository;
    this.userRepository = userRepository;
  }

  public ActivityDto createActivity(ActivityRegistrationDto activityRegistrationDto, Long userId) {

    Activity activity = new Activity(userId,activityRegistrationDto.getTitle(),activityRegistrationDto.getContent());

    Optional<User> user = userRepository.findById(userId);

    String name = user.orElseThrow(NoExistingUser::new).getName();

    return activityRepository.save(activity).toDto(name);

  }
}
