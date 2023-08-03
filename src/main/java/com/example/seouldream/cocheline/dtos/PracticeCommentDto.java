package com.example.seouldream.cocheline.dtos;

import java.time.*;

public class PracticeCommentDto {
  private Long id;
  private Long practicalTemplateId;
  private String userName;
  private String comment;
  private LocalDateTime createdAt;

  public PracticeCommentDto(Long id, Long practicalTemplateId, String userName, String comment, LocalDateTime createdAt) {
    this.id = id;
    this.practicalTemplateId = practicalTemplateId;
    this.userName = userName;
    this.comment = comment;
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
  }

  public Long getActivityId() {
    return practicalTemplateId;
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
