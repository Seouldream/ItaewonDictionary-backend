package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;

import javax.persistence.*;

@Entity
public class Category {
  @Id
  @GeneratedValue
  private Long id;

  public Category() {
  }

  private String name;

  public Category(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Category(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static Category cafe() {
    return new Category( 1L,"cafe");
  }

  public static Category bar() {
    return new Category( 2L,"bar");
  }

  public static Category newCategory() {
    return new Category( 3L,"newCategory");
  }

  public PracticalTemplateCategoryDto toDto() {
    return new PracticalTemplateCategoryDto(id,name);
  }
}
