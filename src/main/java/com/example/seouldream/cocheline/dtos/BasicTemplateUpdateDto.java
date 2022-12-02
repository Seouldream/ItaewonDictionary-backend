package com.example.seouldream.cocheline.dtos;

public class BasicTemplateUpdateDto {
  private String title;
  private String englishSentence;
  private String koreanSentence;
  private String youtubeUrl;
  private String description;

  public BasicTemplateUpdateDto() {
  }

  public BasicTemplateUpdateDto(String title, String englishSentence, String koreanSentence, String youtubeUrl,String description) {
    this.title = title;
    this.englishSentence = englishSentence;
    this.koreanSentence = koreanSentence;
    this.youtubeUrl = youtubeUrl;
    this.description = description;
  }

  public static BasicTemplateUpdateDto fake() {
    return new BasicTemplateUpdateDto(
        "수정된 제목",
        "This has been updated",
        "업데이트 되었습니다.",
        "www.youtube.com","수정됨");
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
