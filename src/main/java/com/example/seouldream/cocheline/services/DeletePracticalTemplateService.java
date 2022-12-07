package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class DeletePracticalTemplateService {
  private PracticalTemplateRepository practicalTemplateRepository;

  public DeletePracticalTemplateService(PracticalTemplateRepository practicalTemplateRepository) {
    this.practicalTemplateRepository = practicalTemplateRepository;
  }

  public void practicalTemplate(Long practicalTemplateId) {
      practicalTemplateRepository.deleteById(practicalTemplateId);
  }
}
