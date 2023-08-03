package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface GrammarRepository extends JpaRepository<Grammar,Long> {
  List<Grammar> findAll();
}
