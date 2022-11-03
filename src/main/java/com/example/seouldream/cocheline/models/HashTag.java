package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
public class HashTag {
  @Id
  @GeneratedValue
  private Long id;
  private String tag;
  private Long studyId;

  public HashTag() {
  }

  public HashTag(Long id, String tag, Long studyId) {
    this.id = id;
    this.tag = tag;
    this.studyId = studyId;
  }

  public HashTag(String tag, Long studyId) {
    this.tag = tag;
    this.studyId = studyId;
  }

  public Long getId() {
    return id;
  }

  public String getTag() {
    return tag;
  }

  public Long getStudyId() {
    return studyId;
  }

  public HashTagDto toDto() {
    return new HashTagDto(tag);
  }

  @Override
  public boolean equals(Object other) {
    HashTag OtherHashTag = (HashTag) other;

    return OtherHashTag.tag.equals(this.tag) &&
        OtherHashTag.studyId.equals(this.studyId);
  }
}
