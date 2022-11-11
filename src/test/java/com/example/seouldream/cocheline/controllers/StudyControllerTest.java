package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
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

@WebMvcTest(StudyController.class)
@ActiveProfiles("test")
class StudyControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StudyService studyService;

  @Test
  void studies() throws Exception {

    given(studyService.list(1)).willReturn(List.of(Study.fake().toDto()));

    mockMvc.perform(MockMvcRequestBuilders.get("/studies"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("Rosie")
        ))
        .andExpect(content().string(
            containsString("holyWater")
        ))
        .andExpect(content().string(
            containsString("hashTags")
        ));
  }

  @Test
  void details() throws Exception {
    given(studyService.findStudy(any()))
        .willReturn(StudyDto.fake());

    mockMvc.perform(MockMvcRequestBuilders.get("/studies/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("holyWater")
        ));
  }

  @Test
  void post() throws Exception {

    given(studyService.createStudy(any(),any(),any(),any(),any(),any(),any(),any()))
        .willReturn(StudyDto.fake());

    mockMvc.perform(MockMvcRequestBuilders.post("/studies/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"title\":\"test1\"," +
                "\"topic\":\"java\"," +
                "\"place\":\"holyWater\"," +
                "\"time\":\"9AM\"," +
                "\"participants\":\"2 people\"," +
                "\"hashTags\":\"java,react\"," +
                "\"content\":\"this is test\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(
            containsString("test1")
        ));
  }
}
