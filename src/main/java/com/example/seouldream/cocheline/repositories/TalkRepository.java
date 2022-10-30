package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface TalkRepository extends JpaRepository<Talk, Long> {
  Optional<Talk> findById(Long id);

  Page<Talk> findAll(Pageable pageable);
}
