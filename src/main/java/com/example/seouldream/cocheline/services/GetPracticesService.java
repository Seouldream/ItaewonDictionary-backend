package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;

import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.stream.*;

@Service
@Transactional
public class GetPracticesService {
  private PracticeRepository practiceRepository;
  private UserRepository userRepository;

  public GetPracticesService(PracticeRepository practiceRepository, UserRepository userRepository) {
    this.practiceRepository = practiceRepository;
    this.userRepository = userRepository;
  }

  public PracticesDto list(Integer page) {
    Sort sort = Sort.by("createdAt").descending();

    Pageable pageable = PageRequest.of(page - 1, 12, sort);

    Page<Practice> practices = practiceRepository.findAll(pageable);

    List<PracticeDto> practiceDtos = practices.stream().map(practice -> practice.toDto(
        userRepository.findById(practice.getUserId()).orElseThrow().getName()
    )).toList();

    PagesDto pagesDto = new PagesDto(practices.getTotalPages());

    return new PracticesDto(practiceDtos, pagesDto);
  }
}
