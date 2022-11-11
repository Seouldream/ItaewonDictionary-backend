package com.example.seouldream.cocheline.dtos;

public class RequestedFreeTalkDto {
  private String title;
  private String hashTags;
  private String content;


  public RequestedFreeTalkDto(String title, String hashTags, String content) {
    this.title = title;
    this.hashTags = hashTags;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public String getHashTags() {
    return hashTags;
  }

  public String getContent() {
    return content;
  }
}
