package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface FreeTalkRepository extends JpaRepository<FreeTalk, Long> {
  Page<FreeTalk> findAll(Pageable pageable);
  Optional<FreeTalk> findById(Long id);
}
