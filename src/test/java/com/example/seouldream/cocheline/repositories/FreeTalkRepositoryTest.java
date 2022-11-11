package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;

import java.util.*;

@SpringBootTest
@ActiveProfiles("test")
class FreeTalkRepositoryTest {

  @Autowired
  private FreeTalkRepository freeTalkRepository;

  @Test
  void creation() {

    FreeTalk freeTalk = new FreeTalk(1L, "Rosie",
        "this is a test case",
        List.of("inquiry", "nuguact"),
        "this is test"
    );

    freeTalkRepository.save(freeTalk);
  }
}
