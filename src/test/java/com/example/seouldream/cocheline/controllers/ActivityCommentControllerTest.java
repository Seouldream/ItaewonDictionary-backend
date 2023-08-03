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

@WebMvcTest(ActivityCommentController.class)
@EnableMockMvc
class ActivityCommentControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetActivityCommentsService getActivityCommentsService;

  @MockBean
  private CreateActivityCommentService createActivityCommentService;

  @SpyBean
  private JwtUtil jwtUtil;

  @Test
  void listOnActivity() throws Exception {

    List<ActivityCommentDto> activityCommentDtos = List.of(
        ActivityComment.fake1().toDto("테스터"),ActivityComment.fake2().toDto("테스터"));

    given(getActivityCommentsService.comments(any())).willReturn(
        new ActivityCommentsDto(activityCommentDtos)
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/activity/comments/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("코멘트1")));
  }

  @Test
  void createCommentOnActivity() throws Exception {

    given(createActivityCommentService.create(any(),any(),any()))
        .willReturn(ActivityComment.fake1().toDto("김명훈"));

    String token = jwtUtil.encode(1L);

    mockMvc.perform(MockMvcRequestBuilders.post("/activity/comments/1")
            .header("Authorization","Bearer " + token)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"content\":\"코멘트\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(containsString("userName")))
        .andExpect(content().string(containsString("김명훈")));
  }
}