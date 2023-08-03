package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.*;

@Entity
public class Category {
  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @CreationTimestamp
  private LocalDateTime createdAt;

  public Category() {
  }

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
