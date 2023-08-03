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
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PracticeCommentController.class)
@EnableMockMvc
class PracticeCommentControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetPracticeCommentsService getPracticeCommentsService;

  @MockBean
  private CreatePracticeCommentService createPracticeCommentService;

  @SpyBean
  private JwtUtil jwtUtil;

  @Test
  void listOnPractice() throws Exception {

    List<PracticeCommentDto> practiceCommentDtos = List.of(
        PracticeComment.fake1().toDto("테스터"),PracticeComment.fake2().toDto("테스터"));

    given(getPracticeCommentsService.comments(any())).willReturn(
        new PracticeCommentsDto(practiceCommentDtos)
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/practice/comments/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("코멘트1")));
  }

  @Test
  void createCommentOnPractice() throws Exception {

    given(createPracticeCommentService.create(any(),any(),any()))
        .willReturn(PracticeComment.fake1().toDto("김명훈"));

    String token = jwtUtil.encode(1L);

    mockMvc.perform(
        MockMvcRequestBuilders.post("/practice/comments/1")
            .header("Authorization","Bearer " + token)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"content\":\"코멘트\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(containsString("코멘트")));
  }
}