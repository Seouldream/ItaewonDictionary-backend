package com.example.seouldream.cocheline.dtos;

import org.springframework.web.multipart.*;

public class PracticalTemplateRegistrationDto {
  private String category;
  private String title;
  private String description;
  private String koreanSentence;
  private String bestPractice;

  public PracticalTemplateRegistrationDto() {
  }

  public PracticalTemplateRegistrationDto(String category,
                                          String title,
                                          String description,
                                          String koreanSentence,
                                          String bestPractice
  ) {
    this.category = category;
    this.title = title;
    this.description = description;
    this.koreanSentence = koreanSentence;
    this.bestPractice = bestPractice;
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

  public static PracticalTemplateRegistrationDto exampleWithCategoryCafe() {
    return new PracticalTemplateRegistrationDto(
        "cafe",
        "커피주문하기",
        "커피 주문할 때 무러보기",
        "마! 커피 한 잔 주문되나!?",
        "can I get a coffee?"
    );
  }

  public static PracticalTemplateRegistrationDto exampleWithCategoryBar() {
    return new PracticalTemplateRegistrationDto(
        "bar",
        "바에서 음료 주문하기",
        "바에서 주문할 때 무러보기",
        "마! 모히또 한 잔 주문되나!?",
        "what kind of drink do you like?");
  }
}
