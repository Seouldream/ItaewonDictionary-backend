package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("practice/comments")
public class PracticeCommentController {
  private GetPracticeCommentsService getPracticeCommentsService;
  private CreatePracticeCommentService createPracticeCommentService;

  public PracticeCommentController(
      GetPracticeCommentsService getPracticeCommentsService,
       CreatePracticeCommentService createPracticeCommentService) {
    this.getPracticeCommentsService = getPracticeCommentsService;
    this.createPracticeCommentService = createPracticeCommentService;
  }


  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PracticeCommentsDto comments(
      @PathVariable(value = "id") Long practiceId
  ) {

    return getPracticeCommentsService.comments(practiceId);
  }

  @PostMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public PracticeCommentDto comment(
      @RequestAttribute("userId") Long userId,
      @PathVariable(value = "id") Long practiceId,
      @RequestBody PracticeCommentRegistrationDto practiceCommentRegistrationDto
  ) {

    return createPracticeCommentService.create(
        practiceId,
        userId,
        practiceCommentRegistrationDto
    );
  }
}
