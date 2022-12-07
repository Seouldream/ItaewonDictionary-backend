package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DeletePracticalTemplateServiceTest {
  private PracticalTemplateRepository practicalTemplateRepository;
  private DeletePracticalTemplateService deletePracticalTemplateService;

  @BeforeEach
  void setUp() {
   practicalTemplateRepository = mock(PracticalTemplateRepository.class);
   deletePracticalTemplateService = new DeletePracticalTemplateService(
       practicalTemplateRepository
   );
  }

  @Test
  void delete() {

    deletePracticalTemplateService.practicalTemplate(1L);

    verify(practicalTemplateRepository).deleteById(any());
  }
}