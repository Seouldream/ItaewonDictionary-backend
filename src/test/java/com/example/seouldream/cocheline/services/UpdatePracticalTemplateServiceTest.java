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

class UpdatePracticalTemplateServiceTest {
  private CategoryRepository categoryRepository;
  private PracticalTemplateRepository practicalTemplateRepository;
  private UpdatePracticalTemplateService updatePracticalTemplateService;

  @BeforeEach
  void setUp() {
    categoryRepository = mock(CategoryRepository.class);
    practicalTemplateRepository = mock(PracticalTemplateRepository.class);
    updatePracticalTemplateService = new UpdatePracticalTemplateService(
        categoryRepository,practicalTemplateRepository
    );

    given(practicalTemplateRepository.findById(1L)).willReturn(Optional.of(PracticalTemplate.example1ByCategoryCafe()));
    given(categoryRepository.findById(any())).willReturn(Optional.of(Category.cafe()));
    given(categoryRepository.save(any())).willReturn(Category.newCategory());
  }

  @Test
  void updateWithoutCategoryChange() {
    Category foundCategory = Category.cafe();

    given(categoryRepository.findByName(any())).willReturn(foundCategory);

    updatePracticalTemplateService.practicalTemplate(
        1L,PracticalTemplateUpdateDto.exampleWithCategoryCafe());

    verify(practicalTemplateRepository).findById(1L);
    verify(categoryRepository).findById(any());
    verify(categoryRepository).findByName(any());
    verify(categoryRepository,never()).save(any());

    PracticalTemplate updatedPracticalTemplate = practicalTemplateRepository.findById(1L)
        .orElseThrow();

    assertThat("수정된 제목").isEqualTo(updatedPracticalTemplate.getTitle());
  }

  @Test
  void updateWithCategoryChangeToExistentOne() {
    Category foundCategory = Category.bar();

    given(categoryRepository.findByName(any())).willReturn(foundCategory);

    updatePracticalTemplateService.practicalTemplate(
        1L,PracticalTemplateUpdateDto.exampleWithCategoryBar());

    verify(practicalTemplateRepository).findById(1L);

    verify(categoryRepository).findById(any());

    verify(categoryRepository).findByName(any());

    verify(categoryRepository,never()).save(any());

    PracticalTemplate updatedPracticalTemplate = practicalTemplateRepository.findById(1L)
        .orElseThrow();

    assertThat("수정된 제목").isEqualTo(updatedPracticalTemplate.getTitle());
  }

  @Test
  void updateWithNewCategory() {
    Category foundCategory = null;

    given(categoryRepository.findByName(any())).willReturn(foundCategory);

    updatePracticalTemplateService.practicalTemplate(
        1L,PracticalTemplateUpdateDto.exampleWithNewCategory());

    verify(practicalTemplateRepository).findById(1L);

    verify(categoryRepository).findById(any());

    verify(categoryRepository).findByName(any());

    verify(categoryRepository).save(any());

    PracticalTemplate updatedPracticalTemplate = practicalTemplateRepository.findById(1L)
        .orElseThrow();

    assertThat("수정된 제목").isEqualTo(updatedPracticalTemplate.getTitle());
    assertThat(3L).isEqualTo(updatedPracticalTemplate.getCategoryId());
  }
}
