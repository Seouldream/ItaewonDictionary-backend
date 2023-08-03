package com.example.seouldream.cocheline.dtos;

public class GrammarContentDto {
  private String content;

  public GrammarContentDto() {
  }

  public GrammarContentDto(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public static GrammarContentDto fake() {
    return new GrammarContentDto("content has been updated");
  }
}
