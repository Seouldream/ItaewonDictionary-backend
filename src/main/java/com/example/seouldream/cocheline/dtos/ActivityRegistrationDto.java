package com.example.seouldream.cocheline.dtos;

public class ActivityRegistrationDto {
  private String title;
  private String content;

  public static ActivityRegistrationDto fake() {
    return new ActivityRegistrationDto("타이틀","컨텐트");
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public ActivityRegistrationDto(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
