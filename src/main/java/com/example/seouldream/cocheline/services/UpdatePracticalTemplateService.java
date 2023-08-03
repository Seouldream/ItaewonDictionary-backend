package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class UpdatePracticalTemplateService {
  private CategoryRepository categoryRepository;
  private PracticalTemplateRepository practicalTemplateRepository;

  public UpdatePracticalTemplateService(CategoryRepository categoryRepository,
                                        PracticalTemplateRepository practicalTemplateRepository) {
    this.categoryRepository = categoryRepository;
    this.practicalTemplateRepository = practicalTemplateRepository;
  }

  public void practicalTemplate(Long practicalTemplateId,
                                PracticalTemplateUpdateDto practicalTemplateUpdateDto) {

    String inputCategoryName = practicalTemplateUpdateDto.getCategory();

    PracticalTemplate foundPracticalTemplate = practicalTemplateRepository.
        findById(practicalTemplateId).orElseThrow();

    Category originalCategory = categoryRepository.findById(foundPracticalTemplate.getCategoryId())
        .orElseThrow();

    Category foundCategory = categoryRepository.findByName(inputCategoryName);

    //동일 카테고리 내에서
    if (originalCategory.getName() == inputCategoryName) {
     foundPracticalTemplate.update(practicalTemplateUpdateDto);
    }
    // 다른 카테고리이지만 기존에 카테고리가 존재할때
    if(originalCategory.getName() != inputCategoryName && foundCategory != null) {

      foundPracticalTemplate.update(foundCategory.getId(),practicalTemplateUpdateDto);
    }
    //다른 카테고리이면서 새 카테고리일때
    if(originalCategory.getName() != inputCategoryName && foundCategory == null) {
      Category newCategory = categoryRepository.save(new Category(inputCategoryName));

      foundPracticalTemplate.update(newCategory.getId(),practicalTemplateUpdateDto);
    }
  }
}
