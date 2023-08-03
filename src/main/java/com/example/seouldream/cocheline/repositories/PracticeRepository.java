package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

public interface PracticeRepository extends JpaRepository<Practice, Long> {
  Page<Practice> findAll(Pageable pageable);
}
