package com.example.seouldream.cocheline.dtos;

import com.example.seouldream.cocheline.models.*;

import java.util.*;

public class TalksDto {
  private List<TalkDto> talks;
  private int pageNumber;

  public List<TalkDto> getTalks() {
    return talks;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public TalksDto() {

  }

  public TalksDto(List<TalkDto> talks, int pageNumber) {
    this.talks = talks;
    this.pageNumber = pageNumber;
  }
}
