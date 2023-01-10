package com.example.seouldream.cocheline.repositories;

import com.example.seouldream.cocheline.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
   User getByUserName(String userName);
   Optional<User> findByUserName(String userName);
}
