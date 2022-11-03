package com.example.seouldream.cocheline.dtos;

import com.example.seouldream.cocheline.models.*;

import java.util.*;

public class RequestedStudyDto {
  private String title;
  private String topic;
  private String place;
  private String time;
  private String participants;
  private String content;
  private String hashTags;

  public RequestedStudyDto() {
  }

  public RequestedStudyDto(
      String title,
      String topic,
      String place,
      String time,
      String participants,
      String content,
      String hashTags) {
    this.title = title;
    this.topic = topic;
    this.place = place;
    this.time = time;
    this.participants = participants;
    this.hashTags = hashTags;
    this.content = content;
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

  public String getHashTags() {
    return hashTags;
  }
}
