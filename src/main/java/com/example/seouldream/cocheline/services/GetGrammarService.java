package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class GetGrammarService {
  private GrammarRepository grammarRepository;

  public GetGrammarService(GrammarRepository grammarRepository) {
    this.grammarRepository = grammarRepository;
  }

  public GrammarDto grammar() {
    Grammar grammar = grammarRepository.findAll().stream().findFirst()
        .orElseThrow(() -> new GrammarNotFound());

    return grammar.toDto();
  }
}
