package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FreeTalkServiceTest {
  private FreeTalkService freeTalkService;
  private FreeTalkHashTagService freeTalkHashTagService;
  private FreeTalkRepository freeTalkRepository;
  @BeforeEach
  void setUp() {
    freeTalkHashTagService = mock(FreeTalkHashTagService.class);
    freeTalkRepository = mock(FreeTalkRepository.class);
    freeTalkService = new FreeTalkService(freeTalkRepository);
  }

  @Test
  void list() {
    FreeTalk freeTalk = new FreeTalk(1L,"tester","test title","content!!");

    List<FreeTalk> freeTalks = new ArrayList<>();
    freeTalks.add(freeTalk);

    Sort sort = Sort.by("createdAt").descending();

    int page = 1;
    Pageable pageable = PageRequest.of(page - 1, 4, sort);

    given(freeTalkRepository.findAll(any(Pageable.class))).willReturn(
        new PageImpl<>(freeTalks)
    );

    assertThat(freeTalkService.list(1)).hasSize(1);

    verify(freeTalkRepository).findAll(pageable);
  }

  @Test
  void findFreeTalkById() {
    FreeTalk freeTalk = new FreeTalk(1L,
        "job hunter","title","this is content");

    given(freeTalkRepository.findById(any()))
        .willReturn(Optional.of(freeTalk));

    freeTalkService.findFreeTalk(freeTalk.getId());

    verify(freeTalkRepository).findById(freeTalk.getId());
  }

  @Test
  void create() {
    FreeTalk freeTalk = new FreeTalk(1L,"tester","test title","content!!");

    given(freeTalkRepository.save(any())).willReturn(freeTalk);

    freeTalkService.create("tester","test title","content!");

    verify(freeTalkRepository).save(any());
  }
}
