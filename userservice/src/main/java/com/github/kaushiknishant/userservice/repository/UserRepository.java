package com.github.kaushiknishant.userservice.repository;

import com.github.kaushiknishant.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByUsername(String username);
}
