package com.example.seouldream.cocheline.models;
import com.example.seouldream.cocheline.dtos.*;

import javax.persistence.*;

@Entity
public class BasicTemplate {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name="title", length = 2048)
  private String title;
  @Column(name="englishSentence", length = 2048)
  private String englishSentence;
  @Column(name="koreanSentence", length = 2048)
  private String koreanSentence;
  @Column(name="youtubeUrl", length = 2048)
  private String youtubeUrl;
  @Column(name="description", length = 2048)
  private String description;

  public BasicTemplate() {
  }

  public BasicTemplate(String title, String englishSentence, String koreanSentence, String youtubeUrl, String description) {
    this.title = title;
    this.englishSentence = englishSentence;
    this.koreanSentence = koreanSentence;
    this.youtubeUrl = youtubeUrl;
    this.description = description;
  }

  public BasicTemplate(Long id,String title, String englishSentence, String koreanSentence, String youtubeUrl, String description) {
    this.id = id;
    this.title = title;
    this.englishSentence = englishSentence;
    this.koreanSentence = koreanSentence;
    this.youtubeUrl = youtubeUrl;
    this.description = description;
  }

  public static BasicTemplate fake1() {
    return new BasicTemplate(1L,
        "인삿말하기",
        "Hi",
        "안녕",
        "www.hi-youtube.com",
        "this could be Hello");
  }

  public static BasicTemplate fake2() {
    return new BasicTemplate(1L,
        "헤어지기",
        "Bye",
        "안녕",
        "www.bye-youtube.com",
        "this could be bye-bye");
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getEnglishSentence() {
    return englishSentence;
  }

  public String getKoreanSentence() {
    return koreanSentence;
  }

  public String getYoutubeUrl() {
    return youtubeUrl;
  }

  public String getDescription() {
    return description;
  }

  public BasicTemplateDto toDto() {
    return new BasicTemplateDto(id,title,englishSentence,koreanSentence,youtubeUrl,description);
  }

  public void update(BasicTemplateUpdateDto basicTemplateUpdateDto) {
    this.title = basicTemplateUpdateDto.getTitle();
    this.englishSentence = basicTemplateUpdateDto.getEnglishSentence();
    this.koreanSentence = basicTemplateUpdateDto.getKoreanSentence();
    this.youtubeUrl = basicTemplateUpdateDto.getYoutubeUrl();
    this.description = basicTemplateUpdateDto.getDescription();
  }
}
