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

class TalkServiceTest {
  private TalkService talkService;
  private TalkRepository talkRepository;

  @SpyBean
  Pageable pageable;

  @BeforeEach
  void setUp() {
    talkRepository = mock(TalkRepository.class);
    talkService = new TalkService(talkRepository);
  }
  @Test
  void list() {
    Talk talk = mock(Talk.class);

    List<Talk> studies = new ArrayList<>();

    studies.add(talk);

    Page<Talk> page = new PageImpl<>(studies);

    given(talkRepository.findAll(any(Pageable.class))).willReturn(page);

    assertThat(talkService.list(1)).isNotNull();

    assertThat(talkService.list(1)).hasSize(1);
  }
}
