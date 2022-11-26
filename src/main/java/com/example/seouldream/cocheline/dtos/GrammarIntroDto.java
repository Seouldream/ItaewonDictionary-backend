package com.example.seouldream.cocheline.dtos;

public class GrammarIntroDto {
  private String introduction;

  public GrammarIntroDto() {
  }

  public GrammarIntroDto(String introduction) {
    this.introduction = introduction;
  }

  public String getIntroduction() {
    return introduction;
  }

  public static GrammarIntroDto fake() {
    return new GrammarIntroDto("updated introduction");
  }
}
