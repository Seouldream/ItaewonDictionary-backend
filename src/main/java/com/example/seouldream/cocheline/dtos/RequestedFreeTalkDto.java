package com.example.seouldream.cocheline.dtos;

public class RequestedFreeTalkDto {
  private String title;
  private String freeTalkHashTags;
  private String content;


  public RequestedFreeTalkDto(String title, String freeTalkHashTags, String content) {
    this.title = title;
    this.freeTalkHashTags = freeTalkHashTags;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public String getFreeTalkHashTags() {
    return freeTalkHashTags;
  }

  public String getContent() {
    return content;
  }
}
