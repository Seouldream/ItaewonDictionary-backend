package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class PracticalTemplatesDto {
  private List<PracticalTemplateDto> practicalTemplates;
  private PagesDto pages;

  public PracticalTemplatesDto(List<PracticalTemplateDto> practicalTemplates,PagesDto pages) {
    this.practicalTemplates = practicalTemplates;
    this.pages=pages;
  }

  public PracticalTemplatesDto(List<PracticalTemplateDto> practicalTemplates) {
    this.practicalTemplates = practicalTemplates;

  }

  public PagesDto getPages() {
    return pages;
  }

  public PracticalTemplatesDto() {
  }

  public List<PracticalTemplateDto> getPracticalTemplates() {
    return practicalTemplates;
  }
}
