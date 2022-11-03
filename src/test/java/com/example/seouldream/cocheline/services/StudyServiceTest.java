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
import static org.mockito.Mockito.verify;

class StudyServiceTest {
  private StudyService studyService;
  private StudyRepository studyRepository;
  private HashTagRepository hashTagRepository;

  @SpyBean
  Pageable pageable;

  @BeforeEach
  void setUp() {
    studyRepository = mock(StudyRepository.class);
    hashTagRepository = mock(HashTagRepository.class);
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

  @Test
  void post() {
    String writer = "tester";
    String title = "one Front man needed";
    String topic = "frontend Engineer";
    String place = "HolyWater";
    String time = "9AM";
    String participants = "2 people";
    String content = "I need a man ,bro";
    Long views = 100L;
    Long likes = 999L;
    Study study = new Study(writer,
        title,
        topic,
        place,
        time,
        participants,
        content,
        views,
        likes);

    studyService.createStudy(
        writer,
        title,
        topic,
        place,
        time,
        participants,
        content
    );

    given(studyRepository.save(study)).willReturn(
        study
    );

    verify(studyRepository).save(any());
  }
}
