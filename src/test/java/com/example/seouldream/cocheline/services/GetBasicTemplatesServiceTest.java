package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetBasicTemplatesServiceTest {
  private BasicTemplateRepository basicTemplateRepository;
  private GetBasicTemplatesService getBasicTemplatesService;

  @BeforeEach
  void setUp() {
    basicTemplateRepository = mock(BasicTemplateRepository.class);
    getBasicTemplatesService = new GetBasicTemplatesService(basicTemplateRepository);
    given(basicTemplateRepository.findAll()).willReturn(List.of(BasicTemplate.fake1(),BasicTemplate.fake2()));
  }

  @Test
  void getBasicTemplateService() {
    List<BasicTemplateDto> basicTemplateDtos = getBasicTemplatesService.basicTemplates();

    verify(basicTemplateRepository).findAll();

    assertEquals(2,basicTemplateDtos.size());
  }
}
