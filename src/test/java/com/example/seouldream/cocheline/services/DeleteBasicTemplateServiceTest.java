package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

class DeleteBasicTemplateServiceTest {
  private BasicTemplateRepository basicTemplateRepository;
  private DeleteBasicTemplateService deleteBasicTemplateService;

  @BeforeEach
  void setUp() {
    basicTemplateRepository = mock(BasicTemplateRepository.class);
    deleteBasicTemplateService = new DeleteBasicTemplateService(basicTemplateRepository);
  }
  @Test
  void delete() {
    given(basicTemplateRepository.findById(1L))
        .willReturn(Optional.of(BasicTemplate.fake1()));

    deleteBasicTemplateService.basicTemplate(1L);

    verify(basicTemplateRepository).deleteById(any());

  }
}
