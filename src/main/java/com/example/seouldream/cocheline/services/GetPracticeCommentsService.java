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
public class GetPracticeCommentsService {
  private PracticeCommentRepository practiceCommentRepository;
  private UserRepository userRepository;

  public GetPracticeCommentsService(PracticeCommentRepository practiceCommentRepository,
                                    UserRepository userRepository) {
    this.practiceCommentRepository = practiceCommentRepository;
    this.userRepository = userRepository;
  }

  public PracticeCommentsDto comments(Long id) {

    List<PracticeComment> practiceComments = practiceCommentRepository.findAllByPracticeId(id);

    List<PracticeCommentDto> practiceCommentDtos = practiceComments.stream()
        .map(PracticeComment -> PracticeComment.toDto(
            userRepository.findById(PracticeComment.getUserId()).orElseThrow(NoExistingUser::new).getName()
        )).toList();

    return new PracticeCommentsDto(practiceCommentDtos);
  }
}
