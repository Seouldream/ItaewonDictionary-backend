package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
public class Study {
  @Id
  @GeneratedValue
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

  public Study(Long id,
               String writer,
               String title,
               String topic,
               String place,
               String time,
               String participants,
               String content,
               Long views,
               Long likes) {
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
  }

  public Study(
      String writer,
      String title,
      String topic,
      String place,
      String time,
      String participants,
      String content,
      Long views,
      Long likes
  ) {
    this.writer = writer;
    this.title = title;
    this.topic = topic;
    this.place = place;
    this.time = time;
    this.participants = participants;
    this.content = content;
    this.views = views;
    this.likes = likes;
  }

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Study() {
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

  public StudyDto toDto(List<HashTagDto> hashTags) {
    String registrationDate = createdAt == null ? "" : createdAt.toLocalDate().toString();

    return new StudyDto(
        id,
        writer,
        title,
        topic,
        place,
        time,
        participants,
        content,
        views,
        likes,
        registrationDate,
        hashTags
    );
  }

  @Override
  public boolean equals(Object other) {
    Study otherStudy = (Study) other;

    return otherStudy.id.equals(this.id) &&
        otherStudy.writer.equals(this.writer) &&
        otherStudy.title.equals(this.title) &&
        otherStudy.topic.equals(this.topic) &&
        otherStudy.place.equals(this.place) &&
        otherStudy.time.equals(this.time) &&
        otherStudy.participants.equals(this.participants) &&
        otherStudy.content.equals(this.content) &&
        otherStudy.views.equals(this.views) &&
        otherStudy.likes.equals(this.likes);
  }

  public void setId(long id) {
    this.id = id;
  }
}
