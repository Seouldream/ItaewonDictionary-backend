package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import com.example.seouldream.cocheline.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.mock.web.*;

import java.io.*;
import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

class CreatePracticeServiceTest {
  private PracticeRepository practiceRepository;
  private UserRepository userRepository;
  private S3Uploader s3Uploader;
  private CreatePracticeService createPracticeService;

  @BeforeEach
  void setUp() {
    practiceRepository = mock(PracticeRepository.class);
    userRepository = mock(UserRepository.class);
    s3Uploader = mock(S3Uploader.class);
    createPracticeService = new CreatePracticeService(practiceRepository,userRepository,s3Uploader);
  }

  @Test
  void createPractice() throws IOException {
    given(userRepository.findById(any())).willReturn(Optional.of(User.fake("김명훈")));
    given(practiceRepository.save(any())).willReturn(Practice.fake());

    MockMultipartFile mockMultipartFile = new MockMultipartFile("multipartFile","filename.txt", "text/plain", "some xml".getBytes());

    createPracticeService.practice(1L, PracticeRegistrationDto.fake(),mockMultipartFile);

    verify(practiceRepository).save(any());
  }
}