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
public class FreeTalkService {
  private FreeTalkRepository freeTalkRepository;
  private Pageable pageable;

  public FreeTalkService(FreeTalkRepository freeTalkRepository) {
    this.freeTalkRepository = freeTalkRepository;
  }

  public List<FreeTalkDto> list(Integer page) {

    Sort sort = Sort.by("createdAt").descending();

    pageable = PageRequest.of(page - 1, 4, sort);

     List<FreeTalkDto> freeTalkDtos = freeTalkRepository.findAll(pageable)
        .stream()
        .map(freeTalk -> freeTalk.toDto())
        .collect(Collectors.toList());

    return freeTalkDtos;
  }

  public int pages() {

    return freeTalkRepository.findAll(pageable).getTotalPages();
  }

  public FreeTalk findFreeTalk(Long id) {

    FreeTalk freeTalk = freeTalkRepository.findById(id).orElseThrow();

    return freeTalk;
  }

  public FreeTalk create(String userId, String title, String content,String hashTags) {

    List<String>  hashTagList = new ArrayList<>();

    for(String hashTag : hashTags.split(",")) {
      hashTagList.add(hashTag);
    }

    FreeTalk freeTalk = new FreeTalk(userId,title,hashTagList,content);

    return freeTalkRepository.save(freeTalk);
  }
}
