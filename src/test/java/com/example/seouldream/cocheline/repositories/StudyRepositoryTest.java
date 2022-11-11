package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.test.context.*;

import java.util.*;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class StudyRepositoryTest {
  @Autowired
  private StudyRepository studyRepository;

  @Test
  void creation() {

    Study study = new Study(1L,"Rosie",
        "test1",
        "java",
        "holyWater",
        "9AM",
        "2 people",
        "this is test",
        List.of("java","react")
    );

    studyRepository.save(study);
  }
}
