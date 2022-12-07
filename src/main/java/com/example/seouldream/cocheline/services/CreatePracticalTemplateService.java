package com.example.seouldream.cocheline.services;
import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class CreatePracticalTemplateService {
  private PracticalTemplateRepository practicalTemplateRepository;
  private CategoryRepository categoryRepository;

  public CreatePracticalTemplateService(
      PracticalTemplateRepository practicalTemplateRepository,
      CategoryRepository categoryRepository) {
    this.practicalTemplateRepository = practicalTemplateRepository;
    this.categoryRepository = categoryRepository;
  }

  public PracticalTemplateDto practicalTemplate(
      PracticalTemplateRegistrationDto practicalTemplateRegistrationDto) {
    String categoryName = practicalTemplateRegistrationDto.getCategory();

    if(categoryRepository.findByName(categoryName) == null ) {
        Category newCategory = categoryRepository.save(new Category(categoryName));

        return practicalTemplateRepository.save(new PracticalTemplate(
            newCategory.getId(),
            practicalTemplateRegistrationDto.getTitle(),
            practicalTemplateRegistrationDto.getDescription(),
            practicalTemplateRegistrationDto.getKoreanSentence(),
            practicalTemplateRegistrationDto.getBestPractice(),
            "녹음 파일"
            )).toDto();
    }

    Long categoryId = categoryRepository.findByName(categoryName).getId();

    return practicalTemplateRepository.save(new PracticalTemplate(
        categoryId,
        practicalTemplateRegistrationDto.getTitle(),
        practicalTemplateRegistrationDto.getDescription(),
        practicalTemplateRegistrationDto.getKoreanSentence(),
        practicalTemplateRegistrationDto.getBestPractice(),
        "녹음 파일"
    )).toDto();
  }
}
