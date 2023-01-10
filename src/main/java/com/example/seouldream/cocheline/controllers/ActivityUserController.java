package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("activity")
public class ActivityUserController {
  private GetActivitiesService getActivitiesService;
  private GetActivityService getActivityService;
  private CreateActivityService createActivityService;

  public ActivityUserController(GetActivitiesService getActivitiesService, GetActivityService getActivityService, CreateActivityService createActivityService) {
    this.getActivitiesService = getActivitiesService;
    this.getActivityService = getActivityService;
    this.createActivityService = createActivityService;
  }

  @GetMapping
  public ActivitiesDto list(
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {
    return getActivitiesService.list(page);
  }

  @GetMapping("/{id}")
  public ActivityDto activity(
      @PathVariable("id") Long id
  ) {
    return getActivityService.activity(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ActivityDto create(
      @RequestAttribute("userId") Long userId,
      @RequestBody ActivityRegistrationDto activityRegistrationDto
  ) {
    return createActivityService.createActivity(activityRegistrationDto,userId);
  }
}
