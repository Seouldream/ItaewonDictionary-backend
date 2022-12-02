package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UpdateBasicTemplateServiceTest {
  private BasicTemplateRepository basicTemplateRepository;
  private UpdateBasicTemplateService updateBasicTemplateService;

  @BeforeEach
  void setUp() {
    basicTemplateRepository = mock(BasicTemplateRepository.class);
    updateBasicTemplateService = new UpdateBasicTemplateService(basicTemplateRepository);
  }

  @Test
  void update() {
    given(basicTemplateRepository.findById(1L))
        .willReturn(Optional.of(BasicTemplate.fake1()));

    updateBasicTemplateService.basicTemplate(1L,BasicTemplateUpdateDto.fake());

    verify(basicTemplateRepository).findById(1L);

    assertThat(basicTemplateRepository.findById(1L).get()
        .getDescription())
        .isEqualTo("수정됨");
  }
}
