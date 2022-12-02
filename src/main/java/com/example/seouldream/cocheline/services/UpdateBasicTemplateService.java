package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class UpdateBasicTemplateService {
  private BasicTemplateRepository basicTemplateRepository;

  public UpdateBasicTemplateService(BasicTemplateRepository basicTemplateRepository) {
    this.basicTemplateRepository = basicTemplateRepository;
  }

  public void basicTemplate(Long id,BasicTemplateUpdateDto basicTemplateUpdateDto) {
    BasicTemplate basicTemplate = basicTemplateRepository
        .findById(id).orElseThrow();

    basicTemplate.update(basicTemplateUpdateDto);
  }
}
