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
public class CreatePracticeCommentService {
  private PracticeCommentRepository practiceCommentRepository;
  private UserRepository userRepository;

  public CreatePracticeCommentService(PracticeCommentRepository practiceCommentRepository,
                                      UserRepository userRepository) {
    this.practiceCommentRepository = practiceCommentRepository;
    this.userRepository = userRepository;
  }

  public PracticeCommentDto create (
      Long practicalTemplateId,
      Long userId,
      PracticeCommentRegistrationDto practiceCommentRegistrationDto) throws NoExistingUser
  {
    PracticeComment practiceComment =
        new PracticeComment(
            practicalTemplateId,
            userId,
            practiceCommentRegistrationDto.getContent()
        );

    Optional<User> user = userRepository.findById(userId);

    String name = user.orElseThrow(NoExistingUser::new).getName();

    return practiceCommentRepository.save(practiceComment).toDto(name);
  }
}
