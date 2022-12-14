package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class CreatePracticalTemplateServiceTest {
  private CategoryRepository categoryRepository;
  private PracticalTemplateRepository practicalTemplateRepository;
  private CreatePracticalTemplateService createPracticalTemplateService;

  @BeforeEach
  void setUp() {
    categoryRepository = mock(CategoryRepository.class);
    practicalTemplateRepository = mock(PracticalTemplateRepository.class);

    createPracticalTemplateService = new CreatePracticalTemplateService(
        practicalTemplateRepository,
        categoryRepository, s3Uploader);
  }

  @Test
  void createWithNewCategory() {

    given(categoryRepository.save(any(Category.class)))
        .willReturn(Category.cafe());

    given(practicalTemplateRepository.save(any(PracticalTemplate.class)))
        .willReturn(PracticalTemplate.example1ByCategoryCafe());

    createPracticalTemplateService.practicalTemplate(PracticalTemplateRegistrationDto.exampleWithCategoryCafe());

    verify(categoryRepository).findByName(any());
    verify(categoryRepository).save(any());
    verify(practicalTemplateRepository).save(any());

  }

  @Test
  void createWithExistentCategoryName() {
    given(categoryRepository.findByName(any())).willReturn(
        Category.cafe()
    );

    given(practicalTemplateRepository.save(any(PracticalTemplate.class)))
        .willReturn(PracticalTemplate.example1ByCategoryCafe());

    createPracticalTemplateService.practicalTemplate(PracticalTemplateRegistrationDto.exampleWithCategoryCafe());

    verify(categoryRepository, times(2)).findByName(any());

    verify(practicalTemplateRepository).save(any());
  }
}
