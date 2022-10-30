package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
public class TalkController {
  private TalkService talkService;

  public TalkController(TalkService talkService) {
    this.talkService = talkService;
  }

  @GetMapping("talks")
  @ResponseStatus(HttpStatus.OK)
  public TalksDto list(
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {
    List<TalkDto> talkDtos =
        talkService.list(page)
            .stream()
            .map(talk -> talk.toDto())
            .collect(Collectors.toList());

    int pageNumber = talkService.pages();

    return new TalksDto(talkDtos,pageNumber);
  }
}
