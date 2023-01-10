package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class ActivitiesDto {
  private List<ActivityDto> activities;
  private PagesDto pages;

  public ActivitiesDto(List<ActivityDto> activities, PagesDto pages) {
    this.activities = activities;
    this.pages = pages;
  }

  public List<ActivityDto> getActivities() {
    return activities;
  }

  public PagesDto getPages() {
    return pages;
  }
}
