package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class DeleteCategoriesService {
  private CategoryRepository categoryRepository;
  private PracticalTemplateRepository practicalTemplateRepository;

  public DeleteCategoriesService(CategoryRepository categoryRepository,
                                 PracticalTemplateRepository practicalTemplateRepository) {
    this.categoryRepository = categoryRepository;
    this.practicalTemplateRepository = practicalTemplateRepository;
  }

  public void categories(CategoryIdListDto categoryIdListDto) {
    List<Long> categoryIds =  categoryIdListDto.getCategories();

    for(Long categoryId : categoryIds) {
      categoryRepository.deleteById(categoryId);
      practicalTemplateRepository.deleteAllByCategoryId(categoryId);
    }



  }
}
