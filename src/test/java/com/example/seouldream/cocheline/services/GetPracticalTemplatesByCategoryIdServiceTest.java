package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetPracticalTemplatesByCategoryIdServiceTest {
  private PracticalTemplateRepository practicalTemplateRepository;
  private GetPracticalTemplatesByCategoryIdService getPracticalTemplatesByCategoryIdService;

  @BeforeEach
  void setUp() {
    practicalTemplateRepository = mock(PracticalTemplateRepository.class);
    getPracticalTemplatesByCategoryIdService = new GetPracticalTemplatesByCategoryIdService(
        practicalTemplateRepository);
  }

  @Test
  void practicalTemplatesByCategoryId() {
    given(practicalTemplateRepository.findAllByCategoryId(any()))
        .willReturn(List.of(PracticalTemplate.example1ByCategoryCafe(),
            PracticalTemplate.example2ByCategoryCafe()));

    List<PracticalTemplateDto> practicalTemplateDtos =
        getPracticalTemplatesByCategoryIdService.practicalTemplates(1L);

    verify(practicalTemplateRepository).findAllByCategoryId(1L);
  }
}
