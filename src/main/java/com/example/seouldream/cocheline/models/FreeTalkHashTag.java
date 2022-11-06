package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;

import javax.persistence.*;

@Entity
public class FreeTalkHashTag {
  @Id
  @GeneratedValue
  private Long id;
  private String tag;
  private Long freeTalkId;

  public FreeTalkHashTag() {
  }

  public FreeTalkHashTag(Long id, String tag, Long freeTalkId) {
    this.id = id;
    this.tag = tag;
    this.freeTalkId = freeTalkId;
  }

  public FreeTalkHashTag(String tag, Long freeTalkId) {
    this.tag = tag;
    this.freeTalkId = freeTalkId;
  }

  public Long getId() {
    return id;
  }

  public String getTag() {
    return tag;
  }

  public Long getFreeTalkId() {
    return freeTalkId;
  }

  public FreeTalkHashTagDto toDto() {
    return new FreeTalkHashTagDto(tag);
  }
}
