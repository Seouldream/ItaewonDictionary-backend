package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController

public class StudyController {
  private StudyService studyService;

  public StudyController(StudyService studyService) {
    this.studyService = studyService;
  }

  @GetMapping("/studies")
  @ResponseStatus(HttpStatus.OK)
  public StudiesDto list(
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {

    List<StudyDto> studyDtos = studyService.list(page);

    int pageNumber = studyService.pages();

    return new StudiesDto(studyDtos, pageNumber);
  }

  @GetMapping("/studies/{id}")
  public StudyDto detail(
      // ToDo RequestAttribute userId 필요
      @PathVariable() Long id
  ) {

    return studyService.findStudy(id);
  }


  @PostMapping("/studies/post")
  @ResponseStatus(HttpStatus.CREATED)
  public StudyDto post(
      // TODO userID 리퀘스트 어트리뷰트로 받아와야함
      @RequestBody RequestedStudyDto requestedStudyDto
  ) {
    String userId = "tester";

     StudyDto studyDto = studyService.createStudy(
        userId,
        requestedStudyDto.getTitle(),
        requestedStudyDto.getTopic(),
        requestedStudyDto.getPlace(),
        requestedStudyDto.getTime(),
        requestedStudyDto.getParticipants(),
        requestedStudyDto.getContent(),
        requestedStudyDto.getHashTags()
        );

    return studyDto;
  }
}
