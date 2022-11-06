package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FreeTalkHashTagServiceTest {
  private FreeTalkHashTagRepository freeTalkHashTagRepository;
  private FreeTalkHashTagService freeTalkHashTagService;

  @BeforeEach
  public void setUp() {
    freeTalkHashTagRepository = mock(FreeTalkHashTagRepository.class);
    freeTalkHashTagService = new FreeTalkHashTagService(freeTalkHashTagRepository);
  }

  @Test
  void list() {
    FreeTalk freeTalk = new FreeTalk(1L,"lighter","title","content");

    FreeTalkHashTag freeTalkHashTag = new FreeTalkHashTag(1L,"취업고민",1L);

    given(freeTalkHashTagRepository.findAllByFreeTalkId(any()))
        .willReturn(List.of(freeTalkHashTag));

    freeTalkHashTagService.list(freeTalk.getId());

    verify(freeTalkHashTagRepository).findAllByFreeTalkId(freeTalk.getId());
  }

  @Test
  void create() {
    FreeTalk freeTalk = new FreeTalk(1L,"lighter","title","content");

    FreeTalkHashTag freeTalkHashTag = new FreeTalkHashTag(1L,"취업고민",1L);

    given(freeTalkHashTagRepository.save(any())).willReturn(freeTalkHashTag);

    freeTalkHashTagService.create(1L,"testTag1");


    verify(freeTalkHashTagRepository).save(any());
  }
}
