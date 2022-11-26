package com.example.seouldream.cocheline.dtos;

public class GrammarDto {
  private Long id;
  private String introduction;
  private String content;

  public GrammarDto() {
  }

  public GrammarDto(Long id, String introduction, String content) {
    this.id = id;
    this.introduction = introduction;
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public String getIntroduction() {
    return introduction;
  }

  public String getContent() {
    return content;
  }

  public static GrammarDto fake() {
    return new GrammarDto(
        1L,"grammar introduction","this is content");
  }
}
