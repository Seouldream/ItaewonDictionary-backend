package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class PatchGrammarContentService {
  private GrammarRepository grammarRepository;

  public PatchGrammarContentService(GrammarRepository grammarRepository) {
    this.grammarRepository = grammarRepository;
  }

  public void content(GrammarContentDto grammarContentDto) {

    String content = grammarContentDto.getContent();

    Grammar grammar = grammarRepository.findAll().stream().findFirst()
        .orElseThrow();

    grammar.updateContent(content);
  }
}
