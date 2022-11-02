package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class StudyServiceTest {
  private StudyService studyService;
  private StudyRepository studyRepository;


  @SpyBean
  Pageable pageable;


  @BeforeEach
  void setUp() {
    studyRepository = mock(StudyRepository.class);
    studyService = new StudyService(studyRepository);
  }

  @Test
  void list() {
    Study study = mock(Study.class);

    List<Study> studies = new ArrayList<>();

    studies.add(study);

    Page<Study> page = new PageImpl<>(studies);

    given(studyRepository.findAll(any(Pageable.class))).willReturn(page);

    assertThat(studyService.list(1)).isNotNull();

    assertThat(studyService.list(1)).hasSize(1);
  }
}
