package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Transient
public class GetBasicTemplatesService {
  private BasicTemplateRepository basicTemplateRepository;

  public GetBasicTemplatesService(BasicTemplateRepository basicTemplateRepository) {
    this.basicTemplateRepository = basicTemplateRepository;
  }

  public List<BasicTemplateDto> basicTemplates() {

    List<BasicTemplate> basicTemplates = basicTemplateRepository.findAll();

    List<BasicTemplateDto> basicTemplateDtos = new ArrayList<>();

    for(BasicTemplate basicTemplate : basicTemplates) {
      basicTemplateDtos.add(basicTemplate.toDto());
    }
    return basicTemplateDtos;
  }
}
