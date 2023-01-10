package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

class DeletePracticeServiceTest {
 private PracticeRepository practiceRepository;
 private DeletePracticeService deletePracticeService;

 @BeforeEach
 void setUp() {
  practiceRepository = mock(PracticeRepository.class);
  deletePracticeService = new DeletePracticeService(practiceRepository);
 }

 @Test
 void delete() {
  deletePracticeService.delete(1L);
  verify(practiceRepository).deleteById(1L);
 }
}
