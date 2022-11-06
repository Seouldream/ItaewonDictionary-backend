package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface FreeTalkHashTagRepository extends JpaRepository<FreeTalkHashTag,Long> {
  List<FreeTalkHashTag> findAllByFreeTalkId(Long freeTalkId);
}
