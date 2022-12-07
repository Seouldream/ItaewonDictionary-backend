package com.example.seouldream.cocheline.dtos;

public class PracticalTemplateUpdateDto {
  private String category;
  private String title;
  private String description;
  private String koreanSentence;
  private String bestPractice;

  public PracticalTemplateUpdateDto(String category, String title, String description, String koreanSentence, String bestPractice) {
    this.category = category;
    this.title = title;
    this.description = description;
    this.koreanSentence = koreanSentence;
    this.bestPractice = bestPractice;
  }

  public PracticalTemplateUpdateDto() {
  }

  public static PracticalTemplateUpdateDto exampleWithCategoryCafe() {
    return new PracticalTemplateUpdateDto(
        "cafe",
        "수정된 제목",
        "수정된 디스크립션",
        "수정된 한국어 문장",
        "수정된 베스트 프렉티스");
  }

  public static PracticalTemplateUpdateDto exampleWithCategoryBar() {
    return new PracticalTemplateUpdateDto(
        "bar",
        "수정된 제목",
        "수정된 디스크립션",
        "수정된 한국어 문장",
        "수정된 베스트 프렉티스");
  }

  public static PracticalTemplateUpdateDto exampleWithNewCategory() {
    return new PracticalTemplateUpdateDto(
        "newCategory",
        "수정된 제목",
        "수정된 디스크립션",
        "수정된 한국어 문장",
        "수정된 베스트 프렉티스");
  }

  public String getCategory() {
    return category;
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
}
