package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetGrammarServiceTest {
  private GrammarRepository grammarRepository;
  private GetGrammarService getGrammarService;

  @BeforeEach
  void setUp() {
    grammarRepository = mock(GrammarRepository.class);

    getGrammarService = new GetGrammarService(grammarRepository);

    given(grammarRepository.findAll()).willReturn(
        List.of(Grammar.fake())
    );

  }

  @Test
  void getGrammarService() {

  GrammarDto grammarDto = getGrammarService.grammar();

  verify(grammarRepository).findAll();

  assertEquals("grammar introduction",grammarDto.getIntroduction());
  }
}
