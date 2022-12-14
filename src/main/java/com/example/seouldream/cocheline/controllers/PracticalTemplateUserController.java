package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/practicalTemplates")
public class PracticalTemplateUserController {
  private GetPracticalTemplateCategoriesService getPracticalTemplateCategoriesService;
  private GetPracticalTemplatesByCategoryIdService getPracticalTemplatesByCategoryIdService;

  public PracticalTemplateUserController(
     GetPracticalTemplateCategoriesService getPracticalTemplateCategoriesService,
     GetPracticalTemplatesByCategoryIdService getPracticalTemplatesByCategoryIdService) {

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

     return getPracticalTemplatesByCategoryIdService.practicalTemplates(categoryId);

  }
}
