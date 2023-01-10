package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.data.domain.*;
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

  public PracticalTemplateCategoriesDto categories(Integer page) {
    Sort sort = Sort.by("CreatedAt").descending();

    Pageable pageable = PageRequest.of(page - 1, 8,sort);

    Page<Category> categories = categoryRepository.findAll(pageable);

    List<PracticalTemplateCategoryDto> categoryDtos = categories.stream().map(Category::toDto).toList();

    PagesDto pagesDto = new PagesDto(categories.getTotalPages());

    return new PracticalTemplateCategoriesDto(categoryDtos,pagesDto);
  }
}
