package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class GetPracticeService {
  private PracticeRepository practiceRepository;
  private UserRepository userRepository;

  public GetPracticeService(PracticeRepository practiceRepository, UserRepository userRepository) {
    this.practiceRepository = practiceRepository;
    this.userRepository = userRepository;
  }

  public PracticeDto practice(Long id) {

    Practice practice = practiceRepository.findById(id).orElseThrow();

    Optional<User> user = userRepository.findById(practice.getUserId());

    String name = user.orElseThrow(NoExistingUser::new).getName();

    return practiceRepository.findById(id).orElseThrow().toDto(name);
  }
}
