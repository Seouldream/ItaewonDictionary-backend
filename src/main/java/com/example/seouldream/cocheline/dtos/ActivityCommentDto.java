package com.example.seouldream.cocheline.dtos;

import java.time.*;

public class ActivityCommentDto {
  private Long id;
  private Long activityId;
  private String userName;
  private String comment;
  private LocalDateTime createdAt;

  public ActivityCommentDto(Long id, Long activityId, String userName, String comment, LocalDateTime createdAt) {
    this.id = id;
    this.activityId = activityId;
    this.userName = userName;
    this.comment = comment;
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
  }

  public Long getActivityId() {
    return activityId;
  }


  public String getUserName() {
    return userName;
  }

  public String getComment() {
    return comment;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
