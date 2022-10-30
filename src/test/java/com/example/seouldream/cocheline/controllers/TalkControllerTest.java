package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.data.domain.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TalkController.class)
@ActiveProfiles("test")
class TalkControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  TalkService talkService;

  @Test
  void list() throws Exception {
    Talk talk = new Talk(1L,"developer1","anyone Here?","I dont see anyone","Java");

    List<Talk> talks  = List.of(talk);

    given(talkService.list(1)).willReturn(
        new PageImpl<>(talks)
    );


    mockMvc.perform(MockMvcRequestBuilders.get("/talks"))
        .andExpect(status().isOk());
  }
}