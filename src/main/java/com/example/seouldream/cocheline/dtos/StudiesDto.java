package com.example.seouldream.cocheline.dtos;

import com.example.seouldream.cocheline.models.*;

import java.util.*;

public class StudiesDto {
  private List<StudyDto> studies;
  private int pageNumber;

  public List<StudyDto> getStudies() {
    return studies;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public StudiesDto() {

  }

  public StudiesDto(List<StudyDto> studies, int pageNumber) {
    this.studies = studies;
    this.pageNumber = pageNumber;
  }
}
