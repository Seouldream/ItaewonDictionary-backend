package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
@Transactional
public class StudyService {
  private StudyRepository studyRepository;

  private Pageable pageable;

  public StudyService(StudyRepository studyRepository) {
    this.studyRepository = studyRepository;
  }

  public Page<Study> list(int page) {

    Sort sort = Sort.by("createdAt").descending();

    pageable = PageRequest.of(page - 1, 4, sort);

    return studyRepository.findAll(pageable);
  }

  public int pages() {
    return studyRepository.findAll(pageable).getTotalPages();
  }

  public Study createStudy(
      String userId,
      String title,
      String topic,
      String place,
      String time,
      String participants,
      String content) {

    Long views = 0L;
    Long likes = 0L;

    Study study = new Study(userId, title, topic, place, time, participants, content, views, likes);
    if(study.getId() == null) {
      study.setId(1000L);
    }

    Study savedStudy = studyRepository.save(study);

    return savedStudy;
  }
}
