package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.config.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableMockMvc
@WebMvcTest(GrammarUserController.class)
class GrammarUserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetGrammarService getGrammarService;

  @BeforeEach
  void setUp() {

  }

  @Test
  void grammar() throws Exception {

    given(getGrammarService.grammar()).willReturn(
        Grammar.fake().toDto()
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/grammar"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("grammar introduction")
        ));
  }

  @Test
  void withoutGrammar() throws Exception {

    given(getGrammarService.grammar()).willThrow(
        GrammarNotFound.class
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/grammar"))
        .andExpect(status().isBadRequest())
        .andExpect(content().string(
            containsString("그래마가 아직 존재하지 않아요!")
        ));;
  }
}
