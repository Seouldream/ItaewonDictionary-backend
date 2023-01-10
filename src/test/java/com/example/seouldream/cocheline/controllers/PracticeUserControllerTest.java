package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.config.*;
import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import com.example.seouldream.cocheline.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.mock.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.io.*;
import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableMockMvc
@WebMvcTest(PracticeUserController.class)
class PracticeUserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetPracticesService getPracticesService;

  @MockBean
  private GetPracticeService getPracticeService;

  @MockBean
  private CreatePracticeService createPracticeService;


  @Test
  void practices() throws Exception {

    given(getPracticesService.list(1)).willReturn(
        new PracticesDto(
            List.of(Practice.fake().toDto("테스터1"),Practice.fake2().toDto("테스터2")),
            new PagesDto(1)));

    mockMvc.perform(MockMvcRequestBuilders.get("/practices?page=1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("테스터1")));
  }

  @Test
  void practice() throws Exception {

    given(getPracticeService.practice(1L)).willReturn(
        Practice.fake().toDto("김명훈")
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/practice/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("카페에서 지갑 잃어버렸을때")));
  }

  @Test
  void create() throws Exception {

    MockMultipartFile multipartFile = new MockMultipartFile("multipartFile", "filename.mp4", "video/mp4", "some xml".getBytes());
    MockMultipartFile jsonFile = new MockMultipartFile("practice", "", "application/json",
        ("{" +
            "\"title\":\"바에서 음료 물어보기\"," +
            "\"situation\":\"바에서 말 걸때\"," +
            "\"koreanScript\":\"어떤 음료 좋아하세요?\"," +
            "\"englishScript\":\"what kind of drink do you like?\"" +
            "}").getBytes());

    given(createPracticeService.practice(any(),any(),any())).willReturn(
        Practice.fake().toDto("김명훈")
    );

    mockMvc.perform(MockMvcRequestBuilders.multipart("/practice/new")
            .file(multipartFile)
            .file(jsonFile)
            .requestAttr("userId",1L))
        .andExpect(status().isCreated())
        .andExpect(content().string(containsString("카페에서 지갑 잃어버렸을때")));

  }
}
