package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("activity/comments")
public class ActivityCommentController {
  private GetActivityCommentsService getActivityCommentsService;
  private CreateActivityCommentService createActivityCommentService;

  public ActivityCommentController(GetActivityCommentsService getActivityCommentsService,
                                   CreateActivityCommentService createActivityCommentService) {
    this.getActivityCommentsService = getActivityCommentsService;
    this.createActivityCommentService = createActivityCommentService;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ActivityCommentsDto comments(
      @PathVariable(value = "id") Long activityId
  ) {

    return getActivityCommentsService.comments(activityId);
  }

  @PostMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public ActivityCommentDto comment(
      @RequestAttribute("userId") Long userId,
      @PathVariable(value = "id") Long activityId,
      @RequestBody ActivityCommentRegistrationDto activityCommentRegistrationDto
  ) {

    return createActivityCommentService.create(
        activityId,
        userId,
        activityCommentRegistrationDto);
  }
}
