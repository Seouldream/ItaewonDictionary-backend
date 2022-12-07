package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
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

  public List<PracticalTemplateDto> practicalTemplates(Long categoryId) {
    List<PracticalTemplateDto> answer = new ArrayList<>();
    List<PracticalTemplate> practicalTemplates = practicalTemplateRepository
        .findAllByCategoryId(categoryId);

    return practicalTemplates.stream().map(PracticalTemplate::toDto)
        .collect(Collectors.toList());

  }
}
