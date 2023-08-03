package com.example.seouldream.cocheline.dtos;

import org.hibernate.annotations.*;

import java.time.*;

public class PracticeDto {
  private Long id;
  private String userName;
  private String title;
  private String situation;
  private String koreanScript;
  private String englishScript;
  private String recordUrl;
  private String state;
  @CreationTimestamp
  private LocalDateTime createdAt;

  public PracticeDto(Long id, String userName, String title, String situation, String koreanScript, String englishScript, String recordUrl, String state, LocalDateTime createdAt) {
    this.id = id;
    this.userName = userName;
    this.title = title;
    this.situation = situation;
    this.koreanScript = koreanScript;
    this.englishScript = englishScript;
    this.recordUrl = recordUrl;
    this.state = state;
    this.createdAt = createdAt;
  }

  public PracticeDto() {
  }

  public Long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getTitle() {
    return title;
  }

  public String getSituation() {
    return situation;
  }

  public String getKoreanScript() {
    return koreanScript;
  }

  public String getEnglishScript() {
    return englishScript;
  }

  public String getRecordUrl() {
    return recordUrl;
  }

  public String getState() {
    return state;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
