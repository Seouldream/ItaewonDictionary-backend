package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import java.awt.print.*;

import java.util.*;

public interface StudyRepository extends JpaRepository<Study, Long> {
  Optional<Study> findById(Long id);

  Page<Study> findAll(Pageable pageable);
}
