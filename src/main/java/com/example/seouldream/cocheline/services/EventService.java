package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;
import java.util.stream.*;

@Service
@Transactional
public class EventService {
  private EventRepository eventRepository;
  private Pageable pageable;

  public EventService(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public List<EventDto> list(int page) {

    Sort sort = Sort.by("createdAt").descending();

    pageable = PageRequest.of(page - 1, 4, sort);

    List<EventDto> eventDtos = eventRepository.findAll(pageable)
        .stream()
        .map(event -> event.toDto())
        .collect(Collectors.toList());

    return eventDtos;
  }

  public int pages() {
    return eventRepository.findAll(pageable).getTotalPages();
  }

  public Event findEvent(Long id) {
    Event event = eventRepository.findById(id).orElseThrow();

    return event;
  }

  public Event create(String userId,
                      String title,
                      String date,
                      String host,
                      String price,
                      String hostEmail,
                      String hostContact,
                      String onOrOffline,
                      String eventType,
                      String category,
                      String homepageAddress,
                      String imgUrl,
                      String hashTags,
                      String content) {

    List<String> hashTagList = new ArrayList<>();

    for (String hashTag : hashTags.split(",")) {
      hashTagList.add(hashTag);
    }

    Event savedEvent = eventRepository.save(
        new Event(
            title,
            date,
            host,
            price,
            hostEmail,
            hostContact,
            onOrOffline,
            eventType,
            category,
            homepageAddress,
            imgUrl,
            hashTagList,
            content)
    );

    return savedEvent;
  }
}
