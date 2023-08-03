package com.example.seouldream.cocheline.dtos;

import java.time.*;

public class ActivityDto {
  private Long id;
  private String author;
  private String title;
  private String content;
  private String state;
  private LocalDateTime createdAt;

  public ActivityDto(Long id, String author, String title, String content, String state, LocalDateTime createdAt) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.content = content;
    this.state = state;
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getState() {
    return state;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
