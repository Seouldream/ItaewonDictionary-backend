package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class PracticalTemplateCategoriesDto {
  private List<PracticalTemplateCategoryDto> practicalTemplateCategories;
  public PracticalTemplateCategoriesDto(List<PracticalTemplateCategoryDto> practicalTemplateCategories) {
    this.practicalTemplateCategories = practicalTemplateCategories;
  }

  public List<PracticalTemplateCategoryDto> getPracticalTemplateCategories() {
    return practicalTemplateCategories;
  }
}
