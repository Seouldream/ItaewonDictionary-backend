package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetPracticesServiceTest {
  private PracticeRepository practiceRepository;
  private UserRepository userRepository;
  private GetPracticesService getPracticesService;

  @BeforeEach
  void setUp() {
    practiceRepository = mock(PracticeRepository.class);
    userRepository = mock(UserRepository.class);
    getPracticesService = new GetPracticesService(practiceRepository,userRepository);
  }

  @Test
  void practices() {
    List<Practice> practices = List.of(Practice.fake(), Practice.fake2());

    PageImpl<Practice> practicePages = new PageImpl<>(practices);

    given(userRepository.findById(any())).willReturn(Optional.of(User.fake("김명훈")));

    given(practiceRepository.findAll(any(Pageable.class))).willReturn(
        practicePages
    );

    getPracticesService.list(1);
    
    verify(practiceRepository).findAll(any(Pageable.class));
  }
}