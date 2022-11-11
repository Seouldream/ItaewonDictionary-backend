package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.*;

@RestController
public class EventController {
  private EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/events")
  @ResponseStatus(HttpStatus.OK)
  public EventsDto list(
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {

    List<EventDto> eventDtos = eventService.list(page);

    int pageNumber = eventService.pages();

    return new EventsDto(eventDtos, pageNumber);
  }

  @GetMapping("/events/{id}")
  @ResponseStatus(HttpStatus.OK)
  public EventDto detail(
      @PathVariable() Long id
  ) {
    Event event = eventService.findEvent(id);

    return event.toDto();
  }

  @PostMapping("/events/post")
  @ResponseStatus(HttpStatus.CREATED)
  public EventDto post(
      // TODO userID 리퀘스트 어트리뷰트로 받아와야함
      @RequestBody RequestedEventDto requestedEventDto
  ) {
    String userId = "tester";

    Event event = eventService.create(
        userId,
        requestedEventDto.getTitle(),
        requestedEventDto.getDate(),
        requestedEventDto.getHost(),
        requestedEventDto.getPrice(),
        requestedEventDto.getHostEmail(),
        requestedEventDto.getHostContact(),
        requestedEventDto.getOnOrOffline(),
        requestedEventDto.getEventType(),
        requestedEventDto.getCategory(),
        requestedEventDto.getHomepageAddress(),
        requestedEventDto.getImgUrl(),
        requestedEventDto.getHashTags(),
        requestedEventDto.getContent()
        );

    return event.toDto();
  }
}
