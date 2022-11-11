package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface EventRepository extends JpaRepository<Event, Long> {
  Page<Event> findAll(Pageable pageable);
  Optional<Event> findById(Long id);
  Event save(Event event);
}
