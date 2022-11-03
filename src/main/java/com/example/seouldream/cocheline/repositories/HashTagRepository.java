package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface HashTagRepository extends JpaRepository<HashTag, Long> {
  List<HashTag> findAllByStudyId(Long studyId);
}
