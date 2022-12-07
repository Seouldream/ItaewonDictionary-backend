package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.config.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableMockMvc
@WebMvcTest(BasicTemplateAdminController.class)
class BasicTemplateAdminControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CreateBasicTemplateService createBasicTemplateService;

  @MockBean
  private UpdateBasicTemplateService updateBasicTemplateService;

  @MockBean
  private DeleteBasicTemplateService deleteBasicTemplateService;

  @Test
  void postBasicTemplate() throws Exception {

    given(createBasicTemplateService.basicTemplate(any()))
        .willReturn(BasicTemplate.fake1().toDto());

    mockMvc.perform(MockMvcRequestBuilders.post("/admin/basicTemplates")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"" +
                "id\":\"1\"," +
                "\"title\":\"인삿말하기\"," +
                "\"englishSentence\":\"Hi\"," +
                "\"koreanSentence\":\"안녕\"," +
                "\"youtubeUrl\":\"www.hi-youtube.com\"," +
                "\"description\":\"this could be Hello\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(
            containsString("this could be Hello")
        ));
  }

  @Test
  void updateBasicTemplate() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.patch("/admin/basicTemplates/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"title\":\"수정\"," +
                "\"englishSentence\":\"수정\"," +
                "\"koreanSentence\":\"수정\"," +
                "\"youtubeUrl\":\"www.hi-youtube.com\"," +
                "\"description\":\"this could be 수정\"" +
                "}"))
        .andExpect(status().isNoContent());

    verify(updateBasicTemplateService).basicTemplate(any(),any());
  }

  @Test
  void deleteBasicTemplate() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.delete("/admin/basicTemplates/1"))
        .andExpect(status().isNoContent());

    verify(deleteBasicTemplateService).basicTemplate(1L);
  }
}
