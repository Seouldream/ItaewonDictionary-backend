package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

@RestController
public class PracticeUserController {
  private final GetPracticesService getPracticesService;
  private final GetPracticeService getPracticeService;
  private final CreatePracticeService createPracticeService;

  public PracticeUserController(GetPracticesService getPracticesService, GetPracticeService getPracticeService, CreatePracticeService createPracticeService) {
    this.getPracticesService = getPracticesService;
    this.getPracticeService = getPracticeService;
    this.createPracticeService = createPracticeService;
  }

  @GetMapping("/practices")
  @ResponseStatus(HttpStatus.OK)
  public PracticesDto list(
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {

    return getPracticesService.list(page);
  }

  @GetMapping("/practice/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PracticeDto practice(
      @PathVariable("id") Long id
  ) {

    return getPracticeService.practice(id);
  }

  @PostMapping(value = "/practice/new",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public PracticeDto createNewPractice(
      @RequestAttribute("userId") Long userId,
      @RequestPart(value = "practice") PracticeRegistrationDto practiceRegistrationDto,
      @RequestPart(value="multipartFile", required = false) MultipartFile multipartFile
  ) throws IOException {

    return createPracticeService.practice(userId,practiceRegistrationDto,multipartFile);
  }
}
