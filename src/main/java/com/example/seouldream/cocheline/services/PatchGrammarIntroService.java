package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;


@Service
@Transactional
public class PatchGrammarIntroService {
  private GrammarRepository grammarRepository;

  public PatchGrammarIntroService(GrammarRepository grammarRepository) {
    this.grammarRepository = grammarRepository;
  }

  public void introduction(GrammarIntroDto grammarIntroDto) {

    String introduction = grammarIntroDto.getIntroduction();

      Grammar grammar = grammarRepository.findAll().stream().findFirst()
          .orElseThrow();

      grammar.updateIntro(introduction);
  }
}
