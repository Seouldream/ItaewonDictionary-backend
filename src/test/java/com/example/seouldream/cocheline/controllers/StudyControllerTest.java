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

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudyController.class)
@ActiveProfiles("test")
class StudyControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StudyService studyService;

  @Test
  void studies() throws Exception {
    Study study = new Study(1L,"any","title of study", "hi~", 1L, 1L);
    HashTag hashTag = new HashTag(1L,"tag",study);

    study = new Study(1L,"any","title of study", "hi~", 1L, 1L,List.of(hashTag));

    List<Study> studies = List.of(study);

    given(studyService.list(1)).willReturn(
        new PageImpl<>(studies)
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/studies"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("title of study")
        ))
        .andExpect(content().string(
            containsString("hi~")
        ))
        .andExpect(content().string(
            containsString("tag")
        ));
  }
}
