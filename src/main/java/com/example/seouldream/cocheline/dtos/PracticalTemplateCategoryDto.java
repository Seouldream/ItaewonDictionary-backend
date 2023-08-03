package com.example.seouldream.cocheline.dtos;

public class PracticalTemplateCategoryDto {
  private Long id;
  private String name;

  public PracticalTemplateCategoryDto() {
  }

  public PracticalTemplateCategoryDto(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
