package com.example.seouldream.cocheline.controllers;
import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import com.example.seouldream.cocheline.utils.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;

@RestController
@RequestMapping("/admin")
public class PracticalTemplateAdminController {
  private CreatePracticalTemplateService createPracticalTemplateService;
  private UpdatePracticalTemplateService updatePracticalTemplateService;
  private DeletePracticalTemplateService deletePracticalTemplateService;
  private DeleteCategoriesService deleteCategoriesService;

  public PracticalTemplateAdminController(CreatePracticalTemplateService createPracticalTemplateService,
                                          UpdatePracticalTemplateService updatePracticalTemplateService,
                                          DeletePracticalTemplateService deletePracticalTemplateService,
                                          DeleteCategoriesService deleteCategoriesService) {
    this.createPracticalTemplateService = createPracticalTemplateService;
    this.updatePracticalTemplateService = updatePracticalTemplateService;
    this.deletePracticalTemplateService = deletePracticalTemplateService;
    this.deleteCategoriesService = deleteCategoriesService;
  }

  @PostMapping(value = "/practicalTemplate",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public PracticalTemplateDto createNewPracticalTemplate(
      @RequestPart(value = "practicalTemplate") PracticalTemplateRegistrationDto practicalTemplateRegistrationDto,
      @RequestPart(value="multipartFile", required = false) MultipartFile multipartFile
    ) throws IOException {

        return createPracticalTemplateService.practicalTemplate(practicalTemplateRegistrationDto,multipartFile);
    }

  @PatchMapping("/practicalTemplate/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updatePracticalTemplate(
      @PathVariable("id") Long practicalTemplateId,
      @RequestBody PracticalTemplateUpdateDto practicalTemplateUpdateDto
  ) {
    updatePracticalTemplateService.practicalTemplate(practicalTemplateId,practicalTemplateUpdateDto);
  }

  @DeleteMapping("/practicalTemplate/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletePracticalTemplate(
      @PathVariable("id") Long practicalTemplateId
  ) {
    deletePracticalTemplateService.practicalTemplate(practicalTemplateId);
  }

  @DeleteMapping("/practicalTemplate/categories")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCategories(
      @RequestBody CategoryIdListDto categoryIdListDto
  ) {
    deleteCategoriesService.categories(categoryIdListDto);
  }
}
