package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class DeletePracticeService {
  private PracticeRepository practiceRepository;

  public DeletePracticeService(PracticeRepository practiceRepository) {
    this.practiceRepository = practiceRepository;
  }

  public void delete(Long id) {
    practiceRepository.deleteById(id);
  }
}
