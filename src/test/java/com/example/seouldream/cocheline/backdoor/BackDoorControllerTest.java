package com.example.seouldream.cocheline.backdoor;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.security.crypto.password.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BackDoorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private PasswordEncoder passwordEncoder;

  @Test
  void deleteAllData() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/backdoor/delete-all"))
        .andExpect(status().isOk());
  }

  @Test
  void setupDatabase() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/backdoor/setup-database"))
        .andExpect(status().isOk());
  }

  @Test
  void setupAdminAccounts() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/backdoor/setup-admin"))
        .andExpect(status().isOk());
  }
}