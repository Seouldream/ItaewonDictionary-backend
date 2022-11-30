package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.config.*;
import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableMockMvc
@WebMvcTest(BasicTemplateUserController.class)
class BasicTemplateUserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetBasicTemplatesService getBasicTemplatesService;

  @BeforeEach
  void setUp() {

  }

  @Test
  void getBasicTemplates() throws Exception {

    given(getBasicTemplatesService.basicTemplates()).willReturn(
        List.of(BasicTemplate.fake1().toDto()
            ,BasicTemplate.fake2().toDto())
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/basicTemplates"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("인삿말하기")
        ));
  }
}
