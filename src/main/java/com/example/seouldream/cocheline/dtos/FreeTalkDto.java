package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class FreeTalkDto {
  Long id;
  String writer;
  String title;
  String content;
  Long views;
  Long likes;
  String registrationDate;
  List<String> hashTags;

  public FreeTalkDto() {
  }

  public FreeTalkDto(Long id,
                     String writer,
                     String title,
                     String content,
                     Long views,
                     Long likes,
                     String registrationDate,
                     List<String> hashTags) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.views = views;
    this.likes = likes;
    this.registrationDate = registrationDate;
    this.hashTags = hashTags;
  }

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

  public Long getViews() {
    return views;
  }

  public Long getLikes() {
    return likes;
  }

  public String getRegistrationDate() {
    return registrationDate;
  }

  public List<String> getHashTags() {
    return hashTags;
  }
}
