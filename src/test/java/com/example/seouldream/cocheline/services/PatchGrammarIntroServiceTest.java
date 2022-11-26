package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PatchGrammarIntroServiceTest {

  private GrammarRepository grammarRepository;

  private PatchGrammarIntroService patchGrammarIntroService;

  @BeforeEach
  void setUp() {
    grammarRepository = mock(GrammarRepository.class);

    patchGrammarIntroService = new PatchGrammarIntroService(grammarRepository);

    given(grammarRepository.findAll()).willReturn(List.of(Grammar.fake()));
  }

  @Test
  void patchIntro() {
    Grammar grammar = grammarRepository.findAll().stream().findFirst()
        .orElseThrow();

    assertThat(grammar.getIntroduction()).isEqualTo("grammar introduction");

    patchGrammarIntroService.introduction(GrammarIntroDto.fake());

    assertThat(grammar.getIntroduction()).isEqualTo("updated introduction");
  }
}
