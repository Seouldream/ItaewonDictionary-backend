package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.config.*;
import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.services.*;
import com.example.seouldream.cocheline.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableMockMvc
@WebMvcTest(SessionController.class)
class SessionControllerTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  private LoginService loginService;

  @SpyBean
  private JwtUtil jwtUtil;

  @BeforeEach
  void setUp() throws LoginFailed {

    given(loginService.login("tester1234", "password"))
        .willReturn(new LoginResultDto("test123", "김명훈", "user"));

    given(loginService.login("tester1234", "xxx"))
        .willThrow(new LoginFailed());
  }

  @Test
  void loginSuccess() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/session")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"userName\":\"tester1234\"," +
                "\"password\":\"password\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(MockMvcResultMatchers.content().string(
            containsString("\"name\":\"김명훈\"")))
        .andExpect(MockMvcResultMatchers.content().string(
            containsString("\"role\":\"user\"")));
  }

  @Test
  void loginFailed() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/session")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"userName\":\"tester1234\"," +
                "\"password\":\"xxx\"" +
                "}"))
        .andExpect(status().isBadRequest());
  }
}