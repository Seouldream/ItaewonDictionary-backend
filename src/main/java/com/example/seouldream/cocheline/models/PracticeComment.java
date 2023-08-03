package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.*;

@Entity
public class PracticeComment {
  @Id
  @GeneratedValue
  private Long id;
  private Long practiceId;
  private Long userId;
  private String comment;
  @CreationTimestamp
  private LocalDateTime createdAt;

  public PracticeComment() {
  }

  public Long getUserId() {
    return userId;
  }

  public PracticeComment(Long practiceId, Long userId, String comment) {
    this.practiceId = practiceId;
    this.userId = userId;
    this.comment = comment;
  }

  public PracticeComment(Long id, Long practiceId, Long userId, String comment) {
    this.id = id;
    this.practiceId = practiceId;
    this.userId = userId;
    this.comment = comment;
  }

  public static PracticeComment fake1() {
    return new PracticeComment(1L,1L,1L,"코멘트1");
  }
  public static PracticeComment fake2() {
    return new PracticeComment(2L,1L,2L,"코멘트2");
  }

  public PracticeCommentDto toDto(String tester) {
    return new PracticeCommentDto(id,practiceId,tester,comment,createdAt);
  }
}
