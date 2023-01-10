package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface ActivityCommentRepository extends JpaRepository<ActivityComment, Long> {
  List<ActivityComment> findAllByActivityId(Long activityId);
}
