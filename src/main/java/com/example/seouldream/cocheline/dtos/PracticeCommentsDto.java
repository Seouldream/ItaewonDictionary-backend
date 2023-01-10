package com.example.seouldream.cocheline.dtos;

import java.util.*;

public class PracticeCommentsDto {
  private final List<PracticeCommentDto> practiceComments;

  public PracticeCommentsDto(List<PracticeCommentDto> practiceComments) {
    this.practiceComments = practiceComments;
  }

  public List<PracticeCommentDto> getPracticeComments() {
    return practiceComments;
  }
}
