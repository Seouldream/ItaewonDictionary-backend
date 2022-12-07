package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface PracticalTemplateRepository extends JpaRepository<PracticalTemplate, Long> {
  List<PracticalTemplate> findAllByCategoryId(Long categoryId);
}
