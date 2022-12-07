package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class GetPracticalTemplateCategoriesService {
  private CategoryRepository categoryRepository;

  public GetPracticalTemplateCategoriesService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<PracticalTemplateCategoryDto> categories() {

    List<Category> categories = categoryRepository.findAll();

    List<PracticalTemplateCategoryDto> categoryDtos = new ArrayList<>();

    for(Category category : categories) {
      categoryDtos.add(category.toDto());
    }
    return categoryDtos;
  }
}
