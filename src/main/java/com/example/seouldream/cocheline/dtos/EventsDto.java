package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class EventsDto {
  private List<EventDto> events;
  int pageNumber;

  public EventsDto(List<EventDto> events, int pageNumber) {
    this.events = events;
    this.pageNumber = pageNumber;
  }

  public List<EventDto> getEvents() {
    return events;
  }

  public int getPageNumber() {
    return pageNumber;
  }
}
