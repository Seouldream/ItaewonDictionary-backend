package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class PracticalTemplateAdminController {
  private CreatePracticalTemplateService createPracticalTemplateService;
  private UpdatePracticalTemplateService updatePracticalTemplateService;
  private DeletePracticalTemplateService deletePracticalTemplateService;

  public PracticalTemplateAdminController(CreatePracticalTemplateService createPracticalTemplateService,
                                          UpdatePracticalTemplateService updatePracticalTemplateService,
                                          DeletePracticalTemplateService deletePracticalTemplateService) {
    this.createPracticalTemplateService = createPracticalTemplateService;
    this.updatePracticalTemplateService = updatePracticalTemplateService;
    this.deletePracticalTemplateService = deletePracticalTemplateService;
  }

  @PostMapping("/practicalTemplate")
  @ResponseStatus(HttpStatus.CREATED)
  public PracticalTemplateDto createNewPracticalTemplate(
      @RequestBody PracticalTemplateRegistrationDto practicalTemplateRegistrationDto
  ) {
      return createPracticalTemplateService.practicalTemplate(practicalTemplateRegistrationDto);
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
}
