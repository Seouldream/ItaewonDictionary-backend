package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class DeleteBasicTemplateService {
  private BasicTemplateRepository basicTemplateRepository;

  public DeleteBasicTemplateService(BasicTemplateRepository basicTemplateRepository) {
    this.basicTemplateRepository = basicTemplateRepository;
  }

  public void basicTemplate(Long id) {
    basicTemplateRepository.deleteById(id);
  }
}
