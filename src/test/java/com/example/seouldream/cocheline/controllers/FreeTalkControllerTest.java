package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import com.zaxxer.hikari.util.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FreeTalkController.class)
@ActiveProfiles("test")
class FreeTalkControllerTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  FreeTalkService freeTalkService;

  @Test
  void list() throws Exception {

    List<FreeTalk> freeTalks = new ArrayList<>();

    freeTalks.add(FreeTalk.fake());

    given(freeTalkService.list(any()))
        .willReturn(List.of(FreeTalk.fake().toDto()));

    mockMvc.perform(MockMvcRequestBuilders.get("/freeTalks"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("tester")
        ));
  }

  @Test
  void details() throws Exception {
    given(freeTalkService.findFreeTalk(any()))
        .willReturn(FreeTalk.fake());

    mockMvc.perform(MockMvcRequestBuilders.get("/freeTalks/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("this is test freeTalk")
        ));
  }

  @Test
  void post() throws Exception {
    given(freeTalkService.create(any(), any(), any(),any()))
        .willReturn(FreeTalk.fake());

    mockMvc.perform(MockMvcRequestBuilders.post ("/freeTalks/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"title\":\"testTitle\"," +
                "\"hashTags\":\"job,future\"," +
                "\"content\":\"this is test freeTalk\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(
            containsString("this is test freeTalk")));
  }
}
