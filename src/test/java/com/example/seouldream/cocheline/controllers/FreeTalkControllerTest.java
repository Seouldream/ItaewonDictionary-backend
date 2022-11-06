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

  @MockBean
  FreeTalkHashTagService freeTalkHashTagService;

  @Test
  void list() throws Exception {

    FreeTalk freeTalk = new FreeTalk(1L, "writer", "title", "content");

    List<FreeTalk> freeTalks = new ArrayList<>();

    freeTalks.add(freeTalk);

    given(freeTalkService.list(any()))
        .willReturn(new PageImpl<>(freeTalks));

    given(freeTalkHashTagService.list(any()))
        .willReturn(List.of(new FreeTalkHashTagDto("job hunting")));

    mockMvc.perform(MockMvcRequestBuilders.get("/freeTalks"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("job hunting")
        ));

  }

  @Test
  void details() throws Exception {
    given(freeTalkService.findFreeTalk(any()))
        .willReturn(new FreeTalk(1L,
            "jobless Rosie", "new Title", "I am getting a job"));

    mockMvc.perform(MockMvcRequestBuilders.get("/freeTalks/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("jobless Rosie")
        ));
  }

  @Test
  void post() throws Exception {
    given(freeTalkService.create(any(), any(), any()))
        .willReturn(new FreeTalk(
            1L,
            "tester",
            "title!!",
            "this is content!"));

    given(freeTalkHashTagService.create(any(), any())).willReturn(
        List.of(new FreeTalkHashTagDto("java"),
            new FreeTalkHashTagDto("react")
        ));

    mockMvc.perform(MockMvcRequestBuilders.post ("/freeTalks/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"title\":\"title!!\"," +
                "\"hashTags\":\"java,react\"," +
                "\"content\":\"this is content!\"" +
                "}"))
        .andExpect(status().isCreated());
  }
}
