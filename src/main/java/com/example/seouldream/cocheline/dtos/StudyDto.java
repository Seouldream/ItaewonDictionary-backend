package com.example.seouldream.cocheline.dtos;

import com.example.seouldream.cocheline.models.*;

import java.util.*;

public class StudyDto {

  private Long id;
  private String writer;
  private String title;
  private String topic;
  private String place;
  private String time;
  private String participants;
  private String content;
  private Long views;
  private Long likes;
  private String registrationDate;
  private List<String> hashTags;

  public StudyDto() {
  }

  public StudyDto(Long id,
                  String writer,
                  String title,
                  String topic,
                  String place,
                  String time,
                  String participants,
                  String content,
                  Long views,
                  Long likes,
                  String registrationDate,
                  List<String> hashTags
  ) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.topic = topic;
    this.place = place;
    this.time = time;
    this.participants = participants;
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

  public String getTopic() {
    return topic;
  }

  public String getPlace() {
    return place;
  }

  public String getTime() {
    return time;
  }

  public String getParticipants() {
    return participants;
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

  public static StudyDto fake() {
    return Study.fake().toDto();
  }
}
