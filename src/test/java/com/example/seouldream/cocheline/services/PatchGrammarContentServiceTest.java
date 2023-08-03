package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PatchGrammarContentServiceTest {

  private GrammarRepository grammarRepository;

  private PatchGrammarContentService patchGrammarContentService;

  @BeforeEach
  void setUp() {
    grammarRepository = mock(GrammarRepository.class);

    patchGrammarContentService = new PatchGrammarContentService(grammarRepository);

    given(grammarRepository.findAll()).willReturn(List.of(Grammar.fake()));
  }

  @Test
  void patchContent() {
    Grammar grammar = grammarRepository.findAll().stream().findFirst()
        .orElseThrow();

    assertThat(grammar.getContent()).isEqualTo("this is content");

    patchGrammarContentService.content(GrammarContentDto.fake());

    assertThat(grammar.getContent()).isEqualTo("content has been updated");
  }
}
