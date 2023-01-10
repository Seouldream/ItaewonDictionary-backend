package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class PracticesDto {
  private List<PracticeDto> practices;
  private PagesDto pages;

  public PracticesDto(List<PracticeDto> practices, PagesDto pages) {
    this.practices = practices;
    this.pages = pages;
  }

  public List<PracticeDto> getPractices() {
    return practices;
  }

  public PagesDto getPages() {
    return pages;
  }
}
