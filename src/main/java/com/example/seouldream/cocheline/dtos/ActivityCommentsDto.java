package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class ActivityCommentsDto {
  private List<ActivityCommentDto> activityComments;


  public ActivityCommentsDto(List<ActivityCommentDto> activityComments) {
    this.activityComments = activityComments;
  }

  public List<ActivityCommentDto> getActivityComments() {
    return activityComments;
  }
}
