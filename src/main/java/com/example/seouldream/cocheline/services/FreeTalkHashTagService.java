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
public class FreeTalkHashTagService {
  private FreeTalkHashTagRepository freeTalkHashTagRepository;

  public FreeTalkHashTagService(FreeTalkHashTagRepository freeTalkHashTagRepository) {
    this.freeTalkHashTagRepository = freeTalkHashTagRepository;
  }

  public List<FreeTalkHashTagDto> list(Long freeTalkId) {

    List<FreeTalkHashTag> freeTalkHashTags = freeTalkHashTagRepository.findAllByFreeTalkId(freeTalkId);

    return freeTalkHashTags.stream().map(FreeTalkHashTag::toDto).collect(Collectors.toList());
  }

  public List<FreeTalkHashTagDto> create(Long freeTalkId, String freeTalkHashTags) {
    String[] tags = freeTalkHashTags.split(",");

    for(String tag : tags) {
      freeTalkHashTagRepository.save(new FreeTalkHashTag(tag,freeTalkId));
    }

    return freeTalkHashTagRepository.findAllByFreeTalkId(freeTalkId)
        .stream()
        .map(FreeTalkHashTag::toDto)
        .collect(Collectors.toList());
  }
}
