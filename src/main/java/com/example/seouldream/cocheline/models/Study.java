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
  @ElementCollection
  private List<String> hashTags;
  private Long views = 0L;
  private Long likes = 0L;

  public Study(Long id,
               String writer,
               String title,
               String topic,
               String place,
               String time,
               String participants,
               String content,
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
    this.hashTags = hashTags;
  }

  public Study(
      String writer,
      String title,
      String topic,
      String place,
      String time,
      String participants,
      String content,
      List<String> hashTags
  ) {
    this.writer = writer;
    this.title = title;
    this.topic = topic;
    this.place = place;
    this.time = time;
    this.participants = participants;
    this.content = content;
    this.hashTags = hashTags;
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

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public StudyDto toDto() {
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

  public static Study fake() {
    return new Study(1L,"Rosie",
        "test1",
        "java",
        "holyWater",
        "9AM",
        "2 people",
        "this is test",
        List.of("java","react")
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
