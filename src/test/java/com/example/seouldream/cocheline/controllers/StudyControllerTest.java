package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
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

  @MockBean
  private HashTagService hashTagService;

  @Test
  void studies() throws Exception {

    Study study = new Study(1L,
        "rosie",
        "test",
        "test",
        "holywater",
        "9AM",
        "2person",
        "test",
        1L,
        1L);

    List<Study> studies = List.of(study);

    given(hashTagService.list(any())).willReturn(
        List.of(
            new HashTagDto("java"),
            new HashTagDto("tag")
        ));

    given(studyService.list(1)).willReturn(
        new PageImpl<>(List.of(
            new Study(1L,"rosie","test","test","holywater","9AM","2person","test",1L,1L)
        ))
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/studies"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("rosie")
        ))
        .andExpect(content().string(
            containsString("holywater")
        ))
        .andExpect(content().string(
            containsString("tag")
        ));
  }

  @Test
  void details() throws Exception {
    given(studyService.findStudy(any()))
        .willReturn(new Study(1L,"rosie",
            "test1",
            "java",
            "holywater",
            "9AM",
            "2 people",
            "this is test",
            1L,
            1L
        ));

    mockMvc.perform(MockMvcRequestBuilders.get("/studies/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("holywater")
        ));
  }

  @Test
  void post() throws Exception {
    given(studyService.createStudy(any(),any(),any(),any(),any(),any(),any()))
        .willReturn(new Study(1L,"rosie",
            "test1",
            "java",
            "holywater",
            "9AM",
            "2 people",
            "this is test",
            1L,
            1L
            ));

    mockMvc.perform(MockMvcRequestBuilders.post("/studies/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"title\":\"test1\"," +
                "\"topic\":\"java\"," +
                "\"place\":\"holywater\"," +
                "\"time\":\"9AM\"," +
                "\"participants\":\"2 people\"," +
                "\"hashTags\":\"java,react\"," +
                "\"content\":\"this is test\"" +
                "}"))
        .andExpect(status().isCreated());
  }
}
