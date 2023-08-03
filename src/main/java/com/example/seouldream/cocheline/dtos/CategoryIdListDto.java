package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class CategoryIdListDto {
  private List<Long> categories;

  public CategoryIdListDto(List<Long> categories) {
   this.categories = categories;
  }

  public CategoryIdListDto() {
  }

  public List<Long> getCategories() {
    return categories;
  }

  public static CategoryIdListDto cafeAndBarIds() {
    return new CategoryIdListDto(List.of(1L,2L));
  }
}
