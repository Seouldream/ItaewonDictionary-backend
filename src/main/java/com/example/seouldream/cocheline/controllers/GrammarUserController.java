package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class GrammarUserController {
  private GetGrammarService getGrammarService;

  public GrammarUserController(GetGrammarService getGrammarService) {
    this.getGrammarService = getGrammarService;
  }

  @GetMapping("/grammar")
  @ResponseStatus(HttpStatus.OK)
  public GrammarDto grammar() {

    return getGrammarService.grammar();
  }

  @ExceptionHandler(GrammarNotFound.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto grammarNotFound() {
    return new GrammarNotFoundErrorDto();
  }
}
