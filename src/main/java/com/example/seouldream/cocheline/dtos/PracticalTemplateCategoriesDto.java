package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class PracticalTemplateCategoriesDto {
  private List<PracticalTemplateCategoryDto> practicalTemplateCategories;
  private PagesDto pages;

  public PracticalTemplateCategoriesDto(List<PracticalTemplateCategoryDto> practicalTemplateCategories, PagesDto pages) {
    this.practicalTemplateCategories = practicalTemplateCategories;
    this.pages = pages;
  }

  public List<PracticalTemplateCategoryDto> getPracticalTemplateCategories() {
    return practicalTemplateCategories;
  }

  public PagesDto getPages() {
    return pages;
  }
}
