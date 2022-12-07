package com.example.seouldream.cocheline.dtos;

public class PracticalTemplateDto {
  private Long id;
  private Long categoryId;
  private String title;
  private String description;
  private String koreanSentence;
  private String bestPractice;
  private String recordUrl;

  public PracticalTemplateDto(Long id, Long categoryId, String title, String description, String koreanSentence, String bestPractice, String recordUrl) {
    this.id = id;
    this.categoryId = categoryId;
    this.title = title;
    this.description = description;
    this.koreanSentence = koreanSentence;
    this.bestPractice = bestPractice;
    this.recordUrl = recordUrl;
  }

  public Long getId() {
    return id;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getKoreanSentence() {
    return koreanSentence;
  }

  public String getBestPractice() {
    return bestPractice;
  }

  public String getRecordUrl() {
    return recordUrl;
  }
}
