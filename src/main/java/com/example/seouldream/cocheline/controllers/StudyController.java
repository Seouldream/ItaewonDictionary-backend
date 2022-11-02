package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.data.domain.*;
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
    List<StudyDto> studyDtos =
        studyService.list(page)
            .stream()
            .map(Study::toDto)
            .collect(Collectors.toList());

    int pageNumber = studyService.pages();

    return new StudiesDto(studyDtos, pageNumber);
  }
}
