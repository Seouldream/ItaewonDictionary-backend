package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;

@RestController
@RequestMapping("/admin")
public class GrammarAdminController {
  private CreateGrammarService createGrammarService;
  private PatchGrammarIntroService patchGrammarIntroService;
  private PatchGrammarContentService patchGrammarContentService;

  public GrammarAdminController(CreateGrammarService createGrammarService,
                                PatchGrammarIntroService patchGrammarIntroService,
                                PatchGrammarContentService patchGrammarContentService
                                ) {
    this.createGrammarService = createGrammarService;
    this.patchGrammarIntroService = patchGrammarIntroService;
    this.patchGrammarContentService = patchGrammarContentService;
  }

  @PostMapping("/grammar")
  @ResponseStatus(HttpStatus.CREATED)
  public GrammarDto grammar(
      @RequestBody GrammarDto grammarDto
  ) {
    return createGrammarService.grammar(grammarDto);
  }
  @PatchMapping("/grammar-introduction")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void introduction(
      @RequestBody GrammarIntroDto grammarIntroDto
  ) {
      patchGrammarIntroService.introduction(grammarIntroDto);
  }

  @PatchMapping("/grammar-content")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void content(
      @RequestBody GrammarContentDto grammarContentDto
  ) {
    patchGrammarContentService.content(grammarContentDto);
  }
}
