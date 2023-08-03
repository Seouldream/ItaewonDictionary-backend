package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Grammar {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name="introduction", length = 2048)
  private String introduction;
  @Column(name="content", length = 2048)
  private String content;

  public Grammar() {
  }

  public Grammar(String introduction, String content) {
    this.introduction = introduction;
    this.content = content;
  }

  public Grammar(Long id, String introduction, String content) {
    this.id = id;
    this.introduction = introduction;
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public String getIntroduction() {
    return introduction;
  }

  public String getContent() {
    return content;
  }

  public static Grammar fake() {
return new Grammar(1L,"grammar introduction","this is content");
  }

  public GrammarDto toDto() {
    return new GrammarDto(id,introduction,content);
  }

  public void updateIntro(String introduction) {
    this.introduction = introduction;
  }

  public void updateContent(String content) {
    this.content = content;
  }
}
