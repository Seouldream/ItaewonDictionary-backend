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
  private String content;
  private Long views;
  private Long likes;

  @JsonManagedReference
  @OneToMany(mappedBy = "study")
  private List<HashTag> hashTags = new ArrayList<>();

  public Study(Long id,
               String writer,
               String title,
               String content,
               Long views,
               Long likes,
               List<HashTag> hashTags) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.views = views;
    this.likes = likes;
    this.hashTags = hashTags;
  }

  public Study(Long id, String writer, String title, String content, Long views, Long likes) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.views = views;
    this.likes = likes;
  }

  public Long getViews() {
    return views;
  }

  public Long getLikes() {
    return likes;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
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

  public String getContent() {
    return content;
  }

  public StudyDto toDto() {
    String registrationDate = createdAt == null ? "" : createdAt.toLocalDate().toString();

    return new StudyDto(
        id,
        writer,
        title,
        content,
        views,
        likes,
        registrationDate,
        hashTags
    );
  }
}
