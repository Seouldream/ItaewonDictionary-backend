package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class BasicTemplatesDto {
  private List<BasicTemplateDto> basicTemplates;

  public BasicTemplatesDto(List<BasicTemplateDto> basicTemplates) {
    this.basicTemplates = basicTemplates;
  }

  public List<BasicTemplateDto> getBasicTemplates() {
    return basicTemplates;
  }
}
