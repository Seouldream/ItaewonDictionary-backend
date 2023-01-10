package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PracticeAdminController.class)
class PracticeAdminControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DeletePracticeService deletePracticeService;

  @Test
  void delete() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/admin/practice/1"))
        .andExpect(status().isNoContent());
  }
}
