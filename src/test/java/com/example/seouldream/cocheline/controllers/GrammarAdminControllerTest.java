package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GrammarAdminController.class)
class GrammarAdminControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CreateGrammarService createGrammarService;

  @MockBean
  private PatchGrammarIntroService patchGrammarIntroService;

  @MockBean
  private PatchGrammarContentService patchGrammarContentService;

  @BeforeEach
  void setUp() {

  }

  @Test
  void createGrammar() throws Exception {

    given(createGrammarService.grammar(GrammarDto.fake()))
        .willReturn(Grammar.fake().toDto());

    mockMvc.perform(MockMvcRequestBuilders.post("/admin/grammar")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"introduction\":\"grammar introduction\"," +
                " \"content\":\"this is content\"" +
                "}"))
        .andExpect(status().isCreated());

    verify(createGrammarService).grammar(any());
  }

  @Test
  void patchIntroduction() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.patch("/admin/grammar-introduction")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                "{" +
                    "\"introduction\":\"updated introduction\"" +
                    "}"
            ))
          .andExpect(status().isNoContent());

    verify(patchGrammarIntroService).introduction(any());
  }

  @Test
  void patchIContent() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.patch("/admin/grammar-content")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                "{" +
                    "\"content\":\"content has been updated\"" +
                    "}"
            ))
        .andExpect(status().isNoContent());

    verify(patchGrammarContentService).content(any());
  }
}
