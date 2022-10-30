package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.controllers.*;
import com.example.seouldream.cocheline.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.*;

@Entity
public class Talk {
  @Id
  @GeneratedValue
  private Long id;
  private String writer;
  private String title;
  private String content;
  private String hashTag;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Talk() {
  }

  public Talk(Long id, String writer, String title, String content, String hashTag) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.hashTag = hashTag;
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

  public String getHashTag() {
    return hashTag;
  }

  public TalkDto toDto() {
    return new TalkDto(id,writer,title,content,hashTag);
  }
}
