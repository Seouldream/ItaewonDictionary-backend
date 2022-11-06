package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
public class FreeTalkController {
  private FreeTalkService freeTalkService;
  private FreeTalkHashTagService freeTalkHashTagService;

  public FreeTalkController(FreeTalkService freeTalkService, FreeTalkHashTagService freeTalkHashTagService) {
    this.freeTalkService = freeTalkService;
    this.freeTalkHashTagService = freeTalkHashTagService;
  }

  @GetMapping("/freeTalks")
  @ResponseStatus(HttpStatus.OK)
  public FreeTalksDto list(
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {

    List<FreeTalkDto> freeTalkDtos =
        freeTalkService.list(page)
            .stream()
            .map(freeTalk -> freeTalk.toDto(freeTalkHashTagService.list(freeTalk.getId())))
            .collect(Collectors.toList());

    int pageNumber = freeTalkService.pages();

    return new FreeTalksDto(freeTalkDtos, pageNumber);
  }

  @GetMapping("/freeTalks/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FreeTalkDto detail(
      @PathVariable() Long id
  ) {
    FreeTalk freeTalk = freeTalkService.findFreeTalk(id);

    List<FreeTalkHashTagDto> freeTalkHashTagDtos = freeTalkHashTagService.list(freeTalk.getId());

    return freeTalk.toDto(freeTalkHashTagDtos);
  }

  @PostMapping("/freeTalks/post")
  @ResponseStatus(HttpStatus.CREATED)
  public FreeTalkDto post(
      // TODO userID 리퀘스트 어트리뷰트로 받아와야함
      @RequestBody RequestedFreeTalkDto requestedFreeTalkDto
  ) {
    String userId = "tester";

    FreeTalk freeTalk = freeTalkService.create(
        userId,
        requestedFreeTalkDto.getTitle(),
        requestedFreeTalkDto.getContent()
        );

  List<FreeTalkHashTagDto> freeTalkHashTagDtos =
      freeTalkHashTagService.create(
          freeTalk.getId(),
          requestedFreeTalkDto.getFreeTalkHashTags());

    return freeTalk.toDto(freeTalkHashTagDtos);
  }
}
