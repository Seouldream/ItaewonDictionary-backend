package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.config.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import com.example.seouldream.cocheline.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableMockMvc
@WebMvcTest(PracticalTemplateUserController.class)
class PracticalTemplateUserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private S3Uploader s3Uploader;

  @MockBean
  private GetPracticalTemplateCategoriesService getPracticalTemplateCategoriesService;

  @MockBean
  private GetPracticalTemplatesByCategoryIdService getPracticalTemplatesByCategoryIdService;

  @BeforeEach()
  void setUp() {

  }

  @Test
  void PracticalTemplateCategory() throws Exception {

    given(getPracticalTemplateCategoriesService.categories()).willReturn(
        List.of(Category.cafe().toDto(), Category.bar().toDto()));

    mockMvc.perform(MockMvcRequestBuilders.get("/practicalTemplates/categories"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("cafe")));
  }

  @Test
  void practicalTemplatesByCategory() throws Exception {

//    given(getPracticalTemplatesByCategoryIdService.practicalTemplates(any(), any(), any()))
//        .willReturn(List.of(PracticalTemplate.example1ByCategoryCafe().toDto(),
//            PracticalTemplate.example2ByCategoryCafe().toDto()));

    mockMvc.perform(MockMvcRequestBuilders.get("/practicalTemplates/categories/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("커피주문하기")));
  }
}
