package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface BasicTemplateRepository extends JpaRepository<BasicTemplate,Long> {
  Optional<BasicTemplate> findById(Long id);
}
