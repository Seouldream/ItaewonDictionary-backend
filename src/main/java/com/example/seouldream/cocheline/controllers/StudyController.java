package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
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

  @GetMapping("studies")
  @ResponseStatus(HttpStatus.OK)
  public StudiesDto list(
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {
    List<StudyDto> studiesDto =
        studyService.list(page)
            .stream()
            .map(study -> study.toDto())
            .collect(Collectors.toList());

    int pageNumber = studyService.pages();

    return new StudiesDto(studiesDto,pageNumber);
  }
}
