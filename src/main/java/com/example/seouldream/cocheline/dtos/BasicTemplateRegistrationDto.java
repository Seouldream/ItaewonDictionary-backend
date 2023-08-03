package com.example.seouldream.cocheline.dtos;

public class BasicTemplateRegistrationDto {
  private String title;
  private String englishSentence;
  private String koreanSentence;
  private String youtubeUrl;
  private String description;

  public BasicTemplateRegistrationDto() {
  }

  public BasicTemplateRegistrationDto(String title, String englishSentence, String koreanSentence, String youtubeUrl, String description) {
    this.title = title;
    this.englishSentence = englishSentence;
    this.koreanSentence = koreanSentence;
    this.youtubeUrl = youtubeUrl;
    this.description = description;
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

  public static BasicTemplateRegistrationDto fake() {
    return new BasicTemplateRegistrationDto(
        "인삿말하기",
        "Hi",
        "안녕",
        "www.hi-youtube.com",
        "this could be Hello");
  }
}
