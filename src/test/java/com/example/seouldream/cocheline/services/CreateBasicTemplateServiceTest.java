package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateBasicTemplateServiceTest {
  private BasicTemplateRepository basicTemplateRepository;
  private CreateBasicTemplateService createBasicTemplateService;

  @BeforeEach
  void setUp() {
    basicTemplateRepository = mock(BasicTemplateRepository.class);
    createBasicTemplateService = new CreateBasicTemplateService(basicTemplateRepository);
  }

  @Test
  void creation() {
    given(basicTemplateRepository.save(any())).willReturn(BasicTemplate.fake1());

    BasicTemplateDto basicTemplateDto =
        createBasicTemplateService.basicTemplate(BasicTemplateRegistrationDto.fake());

    verify(basicTemplateRepository).save(any());

    assertThat(basicTemplateDto.getTitle()).isEqualTo("인삿말하기");
  }
}