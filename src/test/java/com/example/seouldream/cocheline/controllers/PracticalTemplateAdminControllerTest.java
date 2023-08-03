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
import org.springframework.mock.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableMockMvc
@WebMvcTest(PracticalTemplateAdminController.class)
class PracticalTemplateAdminControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CreatePracticalTemplateService createPracticalTemplateService;

  @MockBean
  private UpdatePracticalTemplateService updatePracticalTemplateService;

  @MockBean
  private DeletePracticalTemplateService deletePracticalTemplateService;

  @MockBean
  private DeleteCategoriesService deleteCategoriesService;


  @Test
  void createWithNewCategory() throws Exception {

    given(createPracticalTemplateService.practicalTemplate(any(),any()))
        .willReturn(PracticalTemplate.example1ByCategoryCafe().toDto());

    MockMultipartFile multipartFile = new MockMultipartFile("multipartFile", "filename.txt", "text/plain", "some xml".getBytes());
    MockMultipartFile jsonFile = new MockMultipartFile("practicalTemplate", "", "application/json",
        ("{" +
            "\"category\":\"bar\"," +
            "\"title\":\"바에서 음료 물어보기\"," +
            "\"description\":\"바에서 말 걸때\"," +
            "\"koreanSentence\":\"어떤 음료 좋아하세요?\"," +
            "\"bestPractice\":\"what kind of drink do you like?\"" +
            "}").getBytes());

    mockMvc.perform(MockMvcRequestBuilders.multipart("/admin/practicalTemplate")
                .file(multipartFile)
                .file(jsonFile))
        .andExpect(status().isCreated())
        .andExpect(content().string(containsString("마! 커피 한 잔 주문되나!?")));
  }

  @Test
  void updatePracticalTemplate() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.patch("/admin/practicalTemplate/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"category\":\"newCategory\"," +
                "\"title\":\"수정된 타이틀\"," +
                "\"description\":\"수정된 디스크립션\"," +
                "\"koreanSentence\":\"수정된 한글 문장\"," +
                "\"bestPractice\":\"수정된 베스트 프렉티스\"" +
                "}"))
        .andExpect(status().isNoContent());

    verify(updatePracticalTemplateService).practicalTemplate(any(), any());
  }

  @Test
  void deletePracticalTemplate() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/admin/practicalTemplate/1"))
        .andExpect(status().isNoContent());

    verify(deletePracticalTemplateService).practicalTemplate(1L);
  }

  @Test
  void deleteCategoriesByIds() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/admin/practicalTemplate/categories")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                    "\"data\":[1,2]" +
                "}"))
        .andExpect(status().isNoContent());

    verify(deleteCategoriesService).categories(any());
  }
}
