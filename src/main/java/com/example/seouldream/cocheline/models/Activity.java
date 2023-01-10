package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.*;

@Entity
public class Activity {
  @Id
  @GeneratedValue
  private Long id;
  private Long userId;
  private String title;

  @Column(name="content", length = 2048)
  private String content;

  private String state = "모집중";
  @CreationTimestamp
  private LocalDateTime createdAt;

  public Activity() {
  }

  public Activity(Long userId, String title, String content) {
    this.userId = userId;
    this.title = title;
    this.content = content;
  }

  public Activity(Long id, Long userId, String title, String content) {
    this.id = id;
    this.userId = userId;
    this.title = title;
    this.content = content;
  }

  public Long getUserId() {
    return userId;
  }

  public static Activity fake() {
    return new Activity(1L,2L,"타이틀","컨텐트");
  }

  public static Activity fake2() {
    return new Activity(2L,2L,"타이틀2","컨텐트");
  }

  public ActivityDto toDto(String userNickName) {
    return new ActivityDto(id,userNickName,title,content,state,createdAt);
  }
}
