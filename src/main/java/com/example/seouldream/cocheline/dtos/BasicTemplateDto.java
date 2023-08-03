package com.example.seouldream.cocheline.dtos;

public class BasicTemplateDto {
  private Long id;
  private String title;
  private String englishSentence;
  private String koreanSentence;
  private String youtubeUrl;
  private String description;

  public BasicTemplateDto() {
  }

  public BasicTemplateDto(Long id, String title, String englishSentence, String koreanSentence, String youtubeUrl, String description) {
    this.id = id;
    this.title = title;
    this.englishSentence = englishSentence;
    this.koreanSentence = koreanSentence;
    this.youtubeUrl = youtubeUrl;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getEnglishSentence() {
    return englishSentence;
  }

  public String getKoreanSentence() {
    return koreanSentence;
  }

  public String getYoutubeUrl() {
    return youtubeUrl;
  }

  public String getDescription() {
    return description;
  }
}
