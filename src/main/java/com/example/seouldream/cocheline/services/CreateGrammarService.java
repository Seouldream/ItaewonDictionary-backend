package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class CreateGrammarService {
  private GrammarRepository grammarRepository;

  public CreateGrammarService(GrammarRepository grammarRepository) {
    this.grammarRepository = grammarRepository;
  }

  public GrammarDto grammar(GrammarDto grammarDto) {

    Grammar grammar =  new Grammar(grammarDto.getIntroduction(),grammarDto.getContent());

    Grammar savedGrammar = grammarRepository.save(grammar);

    return savedGrammar.toDto();
  }
}
