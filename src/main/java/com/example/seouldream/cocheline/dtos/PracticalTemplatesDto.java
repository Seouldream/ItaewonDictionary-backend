package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class PracticalTemplatesDto {
  private List<PracticalTemplateDto> practicalTemplates;

  public PracticalTemplatesDto(List<PracticalTemplateDto> practicalTemplates) {
    this.practicalTemplates = practicalTemplates;
  }

  public List<PracticalTemplateDto> getPracticalTemplates() {
    return practicalTemplates;
  }
}
