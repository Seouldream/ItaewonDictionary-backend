package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;

@Service
@Transactional
public class TalkService {
  private TalkRepository talkRepository;
  private Pageable pageable;

  public TalkService(TalkRepository talkRepository) {
    this.talkRepository = talkRepository;
  }

  public Page<Talk> list(int page) {
    Sort sort = Sort.by("createdAt").descending();

    pageable = PageRequest.of(page - 1, 4, sort);

    return talkRepository.findAll(pageable);
  }

  public int pages() {
    return talkRepository.findAll(pageable).getTotalPages();
  }
}
