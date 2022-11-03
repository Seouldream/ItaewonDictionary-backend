package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HashTagServiceTest {

  private StudyRepository studyRepository;
  private HashTagRepository hashTagRepository;
  private HashTagService hashTagService;
  @BeforeEach
  void setUp() {
    studyRepository = mock(StudyRepository.class);
    hashTagRepository = mock(HashTagRepository.class);
    hashTagService = new HashTagService(hashTagRepository);
  }

  @Test
  void findByAllStudyId() {

    hashTagService.list(1l);

    verify(hashTagRepository).findAllByStudyId(any());
  }

  @Test
  void create() {
    given(studyRepository.findById(1L)).willReturn(
        Optional.of(new Study(1L, "test","test","test","test","test","test","test",10L,10L)
    ));

    hashTagService.create(1L,"java,react");

    verify(hashTagRepository).save(new HashTag("java",1L));
    verify(hashTagRepository).save(new HashTag("react",1L));
    verify(hashTagRepository).findAllByStudyId(1L);
  }
}
