package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BasicTemplateUserController {
  public BasicTemplateUserController(GetBasicTemplatesService getBasicTemplatesService) {
    this.getBasicTemplatesService = getBasicTemplatesService;
  }

  private GetBasicTemplatesService getBasicTemplatesService;

  @GetMapping("/basicTemplates")
  @ResponseStatus(HttpStatus.OK)
  public BasicTemplatesDto basicTemplates() {
    List<BasicTemplateDto> basicTemplateDtos = getBasicTemplatesService.basicTemplates();

    return new BasicTemplatesDto(basicTemplateDtos);
  }
}
