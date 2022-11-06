package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.*;
import java.util.*;

@Entity
public class FreeTalk {
  @Id
  @GeneratedValue
  private Long id;
  private String writer;
  private String title;
  private String content;
  private Long views = 0L;
  private Long likes = 0L;

  @CreationTimestamp
  private LocalDateTime createdAt;

  public FreeTalk() {
  }

  public FreeTalk(Long id, String writer, String title, String content) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.content = content;
  }

  public FreeTalk(String writer, String title, String content) {
    this.writer = writer;
    this.title = title;
    this.content = content;
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

  public FreeTalkDto toDto(List<FreeTalkHashTagDto> freeTalkHashTags) {
    String registrationDate = createdAt == null ? "" : createdAt.toLocalDate().toString();

    return new FreeTalkDto(id,writer,title,content,views,likes,registrationDate,freeTalkHashTags);
  }
}
