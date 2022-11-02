package com.example.seouldream.cocheline.dtos;

import com.example.seouldream.cocheline.models.*;

import java.util.*;

public class StudyDto {
  private final Long id;
  private final String writer;
  private final String title;
  private final String content;
  private final Long views;
  private final Long likes;
  private final String registrationDate;
  private final List<HashTag> hashTags;

  public StudyDto(Long id,
                  String writer,
                  String title,
                  String content,
                  Long views,
                  Long likes,
                  String registrationDate,
                  List<HashTag> hashTags) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.views = views;
    this.likes = likes;
    this.registrationDate = registrationDate;
    this.hashTags = hashTags;
  }

  public List<HashTag> getHashTags() {
    return hashTags;
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
}
