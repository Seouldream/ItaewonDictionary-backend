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
public class CreateActivityCommentService {
  private ActivityCommentRepository activityCommentRepository;
  private UserRepository userRepository;

  public CreateActivityCommentService(ActivityCommentRepository activityCommentRepository,
                                      UserRepository userRepository) {
    this.activityCommentRepository = activityCommentRepository;
    this.userRepository = userRepository;
  }

  public ActivityCommentDto create(
      Long activityId,
      Long userId,
      ActivityCommentRegistrationDto activityCommentRegistrationDto) {

    ActivityComment activityComment =
        new ActivityComment(
            activityId,
            userId,
            activityCommentRegistrationDto.getContent()
        );

    Optional<User> user = userRepository.findById(userId);

    String name = user.orElseThrow(NoExistingUser::new).getName();

    return activityCommentRepository.save(activityComment).toDto(name);
  }
}
