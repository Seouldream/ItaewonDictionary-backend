package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.stream.*;

@Service
@Transactional
public class GetPracticalTemplatesByCategoryIdService {
  private PracticalTemplateRepository practicalTemplateRepository;

  public GetPracticalTemplatesByCategoryIdService(PracticalTemplateRepository practicalTemplateRepository) {
    this.practicalTemplateRepository = practicalTemplateRepository;
  }

  public PracticalTemplatesDto practicalTemplates(Long categoryId) {

//    Sort sort = Sort.by("createdAt").descending();
//
//
//    Pageable pageable = PageRequest.of(page - 1, size, sort);

    List<PracticalTemplate> practicalTemplates = practicalTemplateRepository.findAllByCategoryId(categoryId);

    // PagesDto pagesDto = new PagesDto(practicalTemplates.getTotalPages());

    List<PracticalTemplateDto> practicalTemplateDtos = practicalTemplates.stream().map(PracticalTemplate::toDto)
        .collect(Collectors.toList());

    return new PracticalTemplatesDto(practicalTemplateDtos);

  }
}
