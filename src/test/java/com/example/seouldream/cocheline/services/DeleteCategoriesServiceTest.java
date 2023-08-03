package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeleteCategoriesServiceTest {
  private CategoryRepository categoryRepository;
  private PracticalTemplateRepository practicalTemplateRepository;
  private DeleteCategoriesService deleteCategoriesService;

  @BeforeEach
  void setUp() {
    categoryRepository = mock(CategoryRepository.class);
    practicalTemplateRepository = mock(PracticalTemplateRepository.class);
    deleteCategoriesService = new DeleteCategoriesService(categoryRepository,practicalTemplateRepository);
  }

  @Test
  void deleteCategoriesWithAllPracticalTemplates() {

    deleteCategoriesService.categories(CategoryIdListDto.cafeAndBarIds());

    verify(categoryRepository,times(2)).deleteById(any());
    verify(practicalTemplateRepository,times(2)).deleteAllByCategoryId(any());
  }
}