package com.example.seouldream.cocheline.dtos;

public class StudyDto {
  private Long id;
  private String writer;
  private String title;
  private String content;
  private String hashTag;

  public Long getId() {
    return id;
  }

  public String getWriter() {
    return writer;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getHashTag() {
    return hashTag;
  }

  public StudyDto(Long id, String writer, String title, String content, String hashTag) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.hashTag = hashTag;
  }
}
