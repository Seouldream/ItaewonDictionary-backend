package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class GetActivitiesService {
  private ActivityRepository activityRepository;

  private UserRepository userRepository;

  public GetActivitiesService(ActivityRepository activityRepository, UserRepository userRepository) {
    this.activityRepository = activityRepository;
    this.userRepository = userRepository;
  }


  public ActivitiesDto list(Integer page) {
    Sort sort = Sort.by("createdAt").descending();

    Pageable pageable = PageRequest.of(page - 1, 12, sort);

    Page<Activity> activities = activityRepository.findAll(pageable);

    List<ActivityDto> activityDtos = activities.stream().map(Activity -> Activity.toDto(
        userRepository.findById(Activity.getUserId()).orElseThrow(NoExistingUser::new).getName()
    )).toList();

    PagesDto pagesDto = new PagesDto(activities.getTotalPages());

    return new ActivitiesDto(activityDtos, pagesDto);
  }
}
