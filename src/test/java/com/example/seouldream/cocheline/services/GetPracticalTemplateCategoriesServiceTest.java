package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetPracticalTemplateCategoriesServiceTest {
  private CategoryRepository categoryRepository;
  private GetPracticalTemplateCategoriesService getPracticalTemplateCategoriesService;

  @BeforeEach
  void setUp() {
    categoryRepository = mock(CategoryRepository.class);
    getPracticalTemplateCategoriesService = new GetPracticalTemplateCategoriesService(categoryRepository);
    given(categoryRepository.findAll()).willReturn(List.of(Category.cafe(), Category.bar())
    );
  }

  @Test
  void categories() {
    List<PracticalTemplateCategoryDto> categoryDtos = getPracticalTemplateCategoriesService.categories();

    verify(categoryRepository).findAll();
  }
}