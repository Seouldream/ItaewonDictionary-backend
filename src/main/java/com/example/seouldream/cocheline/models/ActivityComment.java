package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.*;

@Entity
public class ActivityComment {
  @Id
  @GeneratedValue
  private Long id;
  private Long activityId;
  private Long userId;
  private String comment;

  @CreationTimestamp
  private LocalDateTime createdAt;

  public ActivityComment() {
  }

  public ActivityComment(Long activityId, Long userId, String comment) {
    this.activityId = activityId;
    this.userId = userId;
    this.comment = comment;
  }

  public ActivityComment(Long id, Long activityId, Long userId, String comment) {
    this.id = id;
    this.activityId = activityId;
    this.userId = userId;
    this.comment = comment;
  }

  public static ActivityComment fake1() {
    return new ActivityComment(1L,1L,1L,"코멘트1");
  }

  public static ActivityComment fake2() {
    return new ActivityComment(2L,1L,2L,"코멘트2");
  }
  public ActivityCommentDto toDto(String name) {
    return new ActivityCommentDto(id,activityId,name,comment,createdAt);
  }

  public Long getUserId() {
    return userId;
  }
}
