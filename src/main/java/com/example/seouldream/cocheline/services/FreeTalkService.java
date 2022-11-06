package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;


import javax.transaction.*;
import java.util.*;

@Service
@Transactional
public class FreeTalkService {
  private FreeTalkRepository freeTalkRepository;
  private Pageable pageable;

  public FreeTalkService(FreeTalkRepository freeTalkRepository) {
    this.freeTalkRepository = freeTalkRepository;
  }

  public Page<FreeTalk> list(Integer page) {

    Sort sort = Sort.by("createdAt").descending();

    pageable = PageRequest.of(page - 1, 4, sort);

    return freeTalkRepository.findAll(pageable);
  }

  public int pages() {

    return freeTalkRepository.findAll(pageable).getTotalPages();
  }

  public FreeTalk findFreeTalk(Long id) {

    FreeTalk freeTalk = freeTalkRepository.findById(id).orElseThrow();

    return freeTalk;
  }

  public FreeTalk create(String userId, String title, String content) {

    FreeTalk freeTalk = new FreeTalk(userId,title,content);

    return freeTalkRepository.save(freeTalk);
  }
}
