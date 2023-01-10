package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import com.example.seouldream.cocheline.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.mock.web.*;

import java.io.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class CreatePracticalTemplateServiceTest {
  private CategoryRepository categoryRepository;
  private PracticalTemplateRepository practicalTemplateRepository;
  private S3Uploader s3Uploader;
  private CreatePracticalTemplateService createPracticalTemplateService;
  private MockMultipartFile multipartFile;

  @BeforeEach
  void setUp() {
    categoryRepository = mock(CategoryRepository.class);
    practicalTemplateRepository = mock(PracticalTemplateRepository.class);

    s3Uploader = mock(S3Uploader.class);

    createPracticalTemplateService = new CreatePracticalTemplateService(
        practicalTemplateRepository,
        categoryRepository, s3Uploader);

    multipartFile = new MockMultipartFile("multipartFile","filename.txt", "text/plain", "some xml".getBytes());
  }

  @Test
  void createWithNewCategory() throws IOException {

    given(categoryRepository.save(any(Category.class)))
        .willReturn(Category.cafe());

   given(practicalTemplateRepository.save(any(PracticalTemplate.class)))
        .willReturn(PracticalTemplate.example1ByCategoryCafe());

    createPracticalTemplateService.practicalTemplate(PracticalTemplateRegistrationDto.exampleWithCategoryCafe(),multipartFile);

    verify(categoryRepository).findByName(any());
    verify(categoryRepository).save(any());
    verify(practicalTemplateRepository).save(any());

  }

  @Test
  void createWithExistentCategoryName() throws IOException {
    given(categoryRepository.findByName(any())).willReturn(
        Category.cafe()
    );

    given(practicalTemplateRepository.save(any(PracticalTemplate.class)))
        .willReturn(PracticalTemplate.example1ByCategoryCafe());



    createPracticalTemplateService.practicalTemplate(PracticalTemplateRegistrationDto.exampleWithCategoryCafe(),multipartFile);

    verify(categoryRepository, times(2)).findByName(any());

    verify(practicalTemplateRepository).save(any());
  }
}
