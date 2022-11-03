package com.example.seouldream.cocheline.dtos;

import com.example.seouldream.cocheline.models.*;

import java.util.*;

public class RequestedStudyDto {
  private final String title;
  private final String topic;
  private final String place;
  private final String time;
  private final String participants;
  private final String content;
  private final String hashTags;

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
    this.content = content;
    this.hashTags = hashTags;
  }
}
