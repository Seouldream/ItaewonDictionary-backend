package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;
import java.util.stream.*;

@Service
@Transactional
public class HashTagService {
  private HashTagRepository hashTagRepository;

  public HashTagService(HashTagRepository hashTagRepository) {
    this.hashTagRepository = hashTagRepository;
  }

  public List<HashTagDto> list(Long studyId) {

    return hashTagRepository.findAllByStudyId(studyId)
        .stream().map(HashTag::toDto)
        .collect(Collectors.toList());
  }

  public List<HashTagDto> create(Long studyId, String hashTags) {

    for(String hashTag : hashTags.split(",")) {

      hashTagRepository.save(new HashTag(hashTag,studyId));
    }

    return hashTagRepository.findAllByStudyId(studyId)
        .stream().map(HashTag::toDto)
        .collect(Collectors.toList());
  }
}
