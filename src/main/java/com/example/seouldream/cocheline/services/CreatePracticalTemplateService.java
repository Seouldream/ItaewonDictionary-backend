package com.example.seouldream.cocheline.services;
import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import com.example.seouldream.cocheline.utils.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;

@Service
@Transactional
public class CreatePracticalTemplateService {
  private PracticalTemplateRepository practicalTemplateRepository;
  private CategoryRepository categoryRepository;
  private S3Uploader s3Uploader;

  public CreatePracticalTemplateService(
      PracticalTemplateRepository practicalTemplateRepository,
      CategoryRepository categoryRepository, S3Uploader s3Uploader) {
    this.practicalTemplateRepository = practicalTemplateRepository;
    this.categoryRepository = categoryRepository;
    this.s3Uploader = s3Uploader;
  }

  public PracticalTemplateDto practicalTemplate(
      PracticalTemplateRegistrationDto practicalTemplateRegistrationDto,
      MultipartFile multipartFile
  ) throws IOException {

    String recordUrl = s3Uploader.uploadFiles(multipartFile, "recordFile");

    String categoryName = practicalTemplateRegistrationDto.getCategory();

    if(categoryRepository.findByName(categoryName) == null ) {
        Category newCategory = categoryRepository.save(new Category(categoryName));

        return practicalTemplateRepository.save(new PracticalTemplate(
            newCategory.getId(),
            practicalTemplateRegistrationDto.getTitle(),
            practicalTemplateRegistrationDto.getDescription(),
            practicalTemplateRegistrationDto.getKoreanSentence(),
            practicalTemplateRegistrationDto.getBestPractice(),
            recordUrl
            )).toDto();
    }

    Long categoryId = categoryRepository.findByName(categoryName).getId();

    return practicalTemplateRepository.save(new PracticalTemplate(
        categoryId,
        practicalTemplateRegistrationDto.getTitle(),
        practicalTemplateRegistrationDto.getDescription(),
        practicalTemplateRegistrationDto.getKoreanSentence(),
        practicalTemplateRegistrationDto.getBestPractice(),
        recordUrl
    )).toDto();
  }
}
