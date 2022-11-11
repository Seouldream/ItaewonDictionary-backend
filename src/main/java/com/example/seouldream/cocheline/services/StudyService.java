package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;
import java.util.stream.*;

@Service
@Transactional
public class StudyService {
  private StudyRepository studyRepository;
  private Pageable pageable;

  public StudyService(StudyRepository studyRepository) {
    this.studyRepository = studyRepository;
  }

  public List<StudyDto> list(int page) {

    Sort sort = Sort.by("createdAt").descending();

    pageable = PageRequest.of(page - 1, 4, sort);

    List<StudyDto> studyDtos = studyRepository.findAll(pageable)
        .stream()
        .map(Study::toDto)
        .collect(Collectors.toList());

    return studyDtos;
  }

  public int pages() {
    return studyRepository.findAll(pageable).getTotalPages();
  }

  public StudyDto findStudy(Long id) {

    Study study = studyRepository.findById(id).orElseThrow();

    return study.toDto();
  }

  public StudyDto createStudy(
      String userId,
      String title,
      String topic,
      String place,
      String time,
      String participants,
      String content,
      String hashTags
  ) {

    List<String> hashTagList = new ArrayList<>();

    for (String hashTag : hashTags.split(",")) {
      hashTagList.add(hashTag);
    }

    Study savedStudy = studyRepository.save(
        new Study(userId, title, topic, place, time, participants,content, hashTagList)
    );

    return savedStudy.toDto();

  }
}
