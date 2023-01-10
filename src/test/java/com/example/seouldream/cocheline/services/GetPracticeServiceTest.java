package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class GetPracticeServiceTest {
  private PracticeRepository practiceRepository;
  private UserRepository userRepository;
  private GetPracticeService getPracticeService;

  @BeforeEach
  void setUp() {
    practiceRepository = mock(PracticeRepository.class);
    userRepository = mock(UserRepository.class);
    getPracticeService = new GetPracticeService(practiceRepository,userRepository);

    given(userRepository.findById(any())).willReturn(Optional.of(User.fake("김명훈")));
    given(practiceRepository.findById(any()))
        .willReturn(Optional.of(Practice.fake()));
  }

  @Test
  void findPractice() {
    PracticeDto practiceDto = getPracticeService.practice(1L);

    verify(practiceRepository,times(2)).findById(1L);

    assertThat(practiceDto.getTitle()).isEqualTo("카페에서 지갑 잃어버렸을때");
  }
}