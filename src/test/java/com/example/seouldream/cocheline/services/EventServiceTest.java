package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EventServiceTest {
  private EventService eventService;
  private EventRepository eventRepository;

  @SpyBean
  Pageable pageable;

  @BeforeEach
  void setUp() {
    eventRepository = mock(EventRepository.class);
    eventService = new EventService(eventRepository);
  }
  @Test
  void list() {

    List<Event> events = new ArrayList<>();

    events.add(Event.fake());

    Sort sort = Sort.by("createdAt").descending();

    int page = 1;

    Pageable pageable = PageRequest.of(page - 1, 4, sort);

    given(eventRepository.findAll(any(Pageable.class))).willReturn(
        new PageImpl<>(events)
    );

    assertThat(eventService.list(1)).isNotNull();

    verify(eventRepository).findAll(pageable);

  }

  @Test
  void findEventById() {
    given(eventRepository.findById(any()))
        .willReturn(Optional.of(Event.fake()));

    eventService.findEvent(Event.fake().getId());

    verify(eventRepository).findById(Event.fake().getId());
  }
}
