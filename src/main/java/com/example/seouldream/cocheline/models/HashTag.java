package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.*;

@Entity
public class HashTag {
  @Id
  @GeneratedValue
  private Long id;
  private String tag;
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "study_id")
  private Study study;

  public HashTag() {
  }

  public HashTag(Long id, String tag, Study study) {
    this.id = id;
    this.tag = tag;
    this.study = study;
  }

  public Long getId() {
    return id;
  }

  public String getTag() {
    return tag;
  }

  public Study getStudy() {
    return study;
  }
}
