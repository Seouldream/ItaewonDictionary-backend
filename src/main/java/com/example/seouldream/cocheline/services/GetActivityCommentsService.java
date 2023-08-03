package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class GetActivityCommentsService {
  private ActivityCommentRepository activityCommentRepository;
  private UserRepository userRepository;

  public GetActivityCommentsService(ActivityCommentRepository activityCommentRepository,
                                    UserRepository userRepository) {
    this.activityCommentRepository = activityCommentRepository;
    this.userRepository = userRepository;

  }

  public ActivityCommentsDto comments(Long id) {

    List<ActivityComment> activityComments = activityCommentRepository.findAllByActivityId(id);

    List<ActivityCommentDto> activityCommentDtos = activityComments.stream()
        .map(ActivityComment -> ActivityComment.toDto(
            userRepository.findById(ActivityComment.getUserId()).orElseThrow().getName()
        )).toList();

    return new ActivityCommentsDto(activityCommentDtos);
  }
}
