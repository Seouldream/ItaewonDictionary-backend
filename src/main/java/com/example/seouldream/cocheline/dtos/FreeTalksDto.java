package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class FreeTalksDto  {
  private List<FreeTalkDto> freeTalks;
  private int pageNumber;

  public FreeTalksDto(List<FreeTalkDto> freeTalks, int pageNumber) {
    this.freeTalks = freeTalks;
    this.pageNumber = pageNumber;
  }

  public List<FreeTalkDto> getFreeTalks() {
    return freeTalks;
  }

  public int getPageNumber() {
    return pageNumber;
  }
}
