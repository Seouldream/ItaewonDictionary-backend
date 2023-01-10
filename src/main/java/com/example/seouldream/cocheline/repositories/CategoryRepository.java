package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  Page<Category> findAll(Pageable pageable);
  Category findByName(String name);
}
