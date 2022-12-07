package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class BasicTemplateAdminController {
  private CreateBasicTemplateService createBasicTemplateService;
  private UpdateBasicTemplateService updateBasicTemplateService;
  private DeleteBasicTemplateService deleteBasicTemplateService;

  public BasicTemplateAdminController(
      CreateBasicTemplateService createBasicTemplateService,
      UpdateBasicTemplateService updateBasicTemplateService,
      DeleteBasicTemplateService deleteBasicTemplateService) {
    this.createBasicTemplateService = createBasicTemplateService;
    this.updateBasicTemplateService = updateBasicTemplateService;
    this.deleteBasicTemplateService = deleteBasicTemplateService;
  }

  @PostMapping("/basicTemplates")
  @ResponseStatus(HttpStatus.CREATED)
  public BasicTemplateDto create(
      @RequestBody BasicTemplateRegistrationDto basicTemplateRegistrationDto
  ) {

    return createBasicTemplateService.basicTemplate(basicTemplateRegistrationDto);
  }

  @PatchMapping("/basicTemplates/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(
      @PathVariable("id") Long id,
      @RequestBody BasicTemplateUpdateDto basicTemplateUpdateDto
  ) {

    updateBasicTemplateService.basicTemplate(id,basicTemplateUpdateDto);
  }

  @DeleteMapping("/basicTemplates/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(
      @PathVariable("id") Long id
  ) {
    deleteBasicTemplateService.basicTemplate(id);
  }
}
