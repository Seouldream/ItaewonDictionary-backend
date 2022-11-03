package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.data.domain.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import javax.lang.model.type.*;
import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    Study study = new Study(1L,"rosie","test","test","holywater","9AM","2person","test",1L,1L);

    System.out.println("null is ...:  " + study.getPlace());

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

    System.out.println("page: " + studyService.list(1).get().findFirst().get().getWriter());
    System.out.println("studies: " + studies.get(0).getWriter());

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
  void post() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/studies/post"))
        .andExpect(status().isCreated());

  }
}
