package com.example.seouldream.cocheline.dtos;

public class PagesDto {
  private Integer totalPages;

  public PagesDto() {
  }

  public PagesDto(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public Integer getTotalPages() {
    return totalPages;
  }
}
