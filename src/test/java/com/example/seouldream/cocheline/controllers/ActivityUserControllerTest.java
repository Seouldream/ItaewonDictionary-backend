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

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableMockMvc
@WebMvcTest(ActivityUserController.class)
class ActivityUserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CreateActivityService createActivityService;

  @MockBean
  private GetActivityService getActivityService;

  @MockBean
  private GetActivitiesService getActivitiesService;

  @SpyBean
  private JwtUtil jwtUtil;

  @Test
  void getActivities() throws Exception {
    given(getActivitiesService.list(1))
        .willReturn(
            new ActivitiesDto(
                List.of(Activity.fake().toDto("테스터1"),Activity.fake2().toDto("테스터2"))
                ,new PagesDto(1)));

    mockMvc.perform(MockMvcRequestBuilders.get("/activity?page=1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("테스터1")));
  }

  @Test
  void getActivity() throws Exception {
    given(getActivityService.activity(any()))
        .willReturn(Activity.fake().toDto("테스터"));

    mockMvc.perform(MockMvcRequestBuilders.get("/activity/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("테스터")));
  }

  @Test
  void createActivity() throws Exception {
    given(createActivityService.createActivity(any(), any()))
        .willReturn(Activity.fake().toDto("테스터"));

    String token = jwtUtil.encode(1L);

    mockMvc.perform(MockMvcRequestBuilders.post("/activity")
            .header("Authorization","Bearer " + token)
        .contentType(MediaType.APPLICATION_JSON)
        .content("{" +
            "\"title\":\"타이틀\"," +
            "\"content\":\"컨텐트\"" +
            "}")
        )
        .andExpect(status().isCreated())
        .andExpect(content().string(containsString("컨텐트")));
  }
}
