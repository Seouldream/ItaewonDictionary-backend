package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EventController.class)
@ActiveProfiles("test")
class EventControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private EventService eventService;

  @Test
  void list() throws Exception {
    given(eventService.list(1)).willReturn(List.of(Event.fake().toDto()));

    mockMvc.perform(MockMvcRequestBuilders.get("/events"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("seedWhale Web seminar")
        ))
        .andExpect(content().string(
            containsString("on 12th Nov")
        ));
  }

  @Test
  void details() throws Exception {
    given(eventService.findEvent(1L)).willReturn(Event.fake());

    mockMvc.perform(MockMvcRequestBuilders.get("/events/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("seedWhale Web seminar")
        ));
  }

  @Test
  void postNewEvent() throws Exception {

    given(eventService.create(
        any(),any(),any(),any(),any(),any(),any(),any(),any(),any(),any(),any(),any(),any()))
        .willReturn(Event.fake());

    mockMvc.perform(MockMvcRequestBuilders.post("/events/post")
                .contentType(MediaType.APPLICATION_JSON)
        .content("{" +
            "\"date\":\"on 12th Nov\"," +
            "\"title\":\"seedWhale Web seminar\"," +
            "\"host\":\"seedWhale\"," +
            "\"price\":\"free\"," +
            "\"hostEmail\":\"megatera@example.com\"," +
            "\"hostContact\":\"1234-8888\"," +
            "\"onOrOffline\":\"online\"," +
            "\"eventType\":\"seminar\"," +
            "\"category\":\"conference\"," +
            "\"homepageAddress\":\"megaptera@megaptera.com\"," +
            "\"imgUrl\":\"https://cdn.pixabay.com/photo/2022/11/03/15/24/coffee-7567749__480.jpg\"," +
            "\"registrationDate\":\"2022.11, 11\"," +
            "\"hashTags\":\"java,react\"," +
            "\"content\":\"this is about a new upcoming Event\"" +
            "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(
            containsString("this post is about a new upcoming Event")
        ));
  }
}
