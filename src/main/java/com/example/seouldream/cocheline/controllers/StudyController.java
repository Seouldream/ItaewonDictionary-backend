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
  private HashTagService hashTagService;

  public StudyController(StudyService studyService, HashTagService hashTagService) {
    this.studyService = studyService;
    this.hashTagService = hashTagService;
  }

  @GetMapping("studies")
  @ResponseStatus(HttpStatus.OK)
  public StudiesDto list(
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {

    List<StudyDto> studyDtos =
        studyService.list(page)
            .stream()
            .map(study -> study.toDto(hashTagService.list(study.getId())))
            .collect(Collectors.toList());

    int pageNumber = studyService.pages();

    return new StudiesDto(studyDtos, pageNumber);
  }

  @PostMapping("studies/post")
  @ResponseStatus(HttpStatus.CREATED)
  public StudyDto post(
      // TODO userID 리퀘스트 어트리뷰트로 받아와야함
      @RequestBody RequestedStudyDto requestedStudyDto
  ) {
    String userId = "tester";

    Study study = studyService.createStudy(
        userId,
        requestedStudyDto.getTitle(),
        requestedStudyDto.getTopic(),
        requestedStudyDto.getPlace(),
        requestedStudyDto.getTime(),
        requestedStudyDto.getParticipants(),
        requestedStudyDto.getContent()
        );

  List<HashTagDto> hashTagDtos = hashTagService.create(study.getId(),requestedStudyDto.getHashTags());
    return study.toDto(hashTagDtos);
  }
}
