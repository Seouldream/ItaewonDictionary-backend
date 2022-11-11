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
  @ElementCollection
  private List<String> hashTags;
  private Long views = 0L;
  private Long likes = 0L;

  @CreationTimestamp
  private LocalDateTime createdAt;

  public FreeTalk() {
  }

  public FreeTalk(Long id, String writer, String title,List<String> hashTags, String content) {
    this.id = id;
    this.writer = writer;
    this.title = title;
    this.hashTags = hashTags;
    this.content = content;
  }

  public FreeTalk(String writer, String title,List<String> hashTags, String content) {
    this.writer = writer;
    this.title = title;
    this.hashTags = hashTags;
    this.content = content;
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

  public FreeTalkDto toDto() {
    String registrationDate = createdAt == null ? "" : createdAt.toLocalDate().toString();

    return new FreeTalkDto(id,writer,title,content,views,likes,registrationDate,hashTags);
  }

  public static FreeTalk fake() {
    return new FreeTalk(
        1L,"tester","testTitle",List.of("job","future"),"this is test freeTalk");
  }
}
