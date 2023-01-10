package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import com.example.seouldream.cocheline.utils.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

@Service
@Transactional
public class CreatePracticeService {
  private PracticeRepository practiceRepository;
  private UserRepository userRepository;
  private S3Uploader s3Uploader;

  public CreatePracticeService(PracticeRepository practiceRepository,
                               UserRepository userRepository,
                               S3Uploader s3Uploader) {
    this.practiceRepository = practiceRepository;
    this.userRepository = userRepository;
    this.s3Uploader = s3Uploader;
  }

  public PracticeDto practice(
      Long userId,
      PracticeRegistrationDto practiceRegistrationDto,
      MultipartFile multipartFile) throws IOException {

    String recordUrl = s3Uploader.uploadFiles(multipartFile, "recordFile");

    Practice practice = new Practice(
        userId,
        practiceRegistrationDto.getTitle(),
        practiceRegistrationDto.getSituation(),
        practiceRegistrationDto.getEnglishScript(),
        practiceRegistrationDto.getKoreanScript(),
        recordUrl,
        "미답변");

    Optional<User> user = userRepository.findById(userId);

    String name = user.orElseThrow(NoExistingUser::new).getName();

    return practiceRepository.save(practice).toDto(name);
  }
}
