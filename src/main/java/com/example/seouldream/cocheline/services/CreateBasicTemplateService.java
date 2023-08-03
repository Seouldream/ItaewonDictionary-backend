package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class CreateBasicTemplateService {
  private final BasicTemplateRepository basicTemplateRepository;

  public CreateBasicTemplateService(BasicTemplateRepository basicTemplateRepository) {
    this.basicTemplateRepository = basicTemplateRepository;
  }

  public BasicTemplateDto basicTemplate(BasicTemplateRegistrationDto basicTemplateRegistrationDto) {
    BasicTemplate basicTemplate = new BasicTemplate(
        basicTemplateRegistrationDto.getTitle(),
        basicTemplateRegistrationDto.getEnglishSentence(),
        basicTemplateRegistrationDto.getKoreanSentence(),
        basicTemplateRegistrationDto.getYoutubeUrl(),
        basicTemplateRegistrationDto.getDescription()
        );

    BasicTemplate savedBasicTemplate = basicTemplateRepository.save(basicTemplate);

    return savedBasicTemplate.toDto();
  }
}
