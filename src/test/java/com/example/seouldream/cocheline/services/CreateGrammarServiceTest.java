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

class CreateGrammarServiceTest {
  private GrammarRepository grammarRepository;
  private CreateGrammarService createGrammarService;

  @BeforeEach
  void setUp() {
    grammarRepository = mock(GrammarRepository.class);

    createGrammarService = new CreateGrammarService(grammarRepository);
  }

  @Test
  void createGrammar() {

    given(grammarRepository.save(any())).willReturn(
        Grammar.fake()
    );

    GrammarDto grammarDto = createGrammarService.grammar(GrammarDto.fake());

    verify(grammarRepository).save(any());

    assertThat(grammarDto.getIntroduction()).isEqualTo("grammar introduction");
  }
}
