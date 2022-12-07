package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import com.example.seouldream.cocheline.utils.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/practicalTemplates")
public class PracticalTemplateUserController {
  private final S3Uploader s3Uploader;
  private GetPracticalTemplateCategoriesService getPracticalTemplateCategoriesService;
  private GetPracticalTemplatesByCategoryIdService getPracticalTemplatesByCategoryIdService;

  public PracticalTemplateUserController(S3Uploader s3Uploader,
     GetPracticalTemplateCategoriesService getPracticalTemplateCategoriesService,
     GetPracticalTemplatesByCategoryIdService getPracticalTemplatesByCategoryIdService) {

    this.s3Uploader = s3Uploader;
    this.getPracticalTemplateCategoriesService = getPracticalTemplateCategoriesService;
    this.getPracticalTemplatesByCategoryIdService = getPracticalTemplatesByCategoryIdService;
  }

  @GetMapping("/categories")
  @ResponseStatus(HttpStatus.OK)
  public PracticalTemplateCategoriesDto categories() {
    List<PracticalTemplateCategoryDto> practicalTemplateCategoryDtos =
        getPracticalTemplateCategoriesService.categories();

    return new PracticalTemplateCategoriesDto(practicalTemplateCategoryDtos);
  }

  @GetMapping("/categories/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PracticalTemplatesDto practicalTemplates(
      @PathVariable("id") Long categoryId
  ) {
    List<PracticalTemplateDto> practicalTemplateDtos =
        getPracticalTemplatesByCategoryIdService.practicalTemplates(categoryId);

    return new PracticalTemplatesDto(practicalTemplateDtos);
  }

  @PostMapping("/upload")
  public String upload(MultipartFile multipartFile) throws IOException {
    return s3Uploader.uploadFiles(multipartFile, "itaewondictionary");
  }
}
