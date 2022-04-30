package com.github.kaushiknishant.userservice.repository;

import com.github.kaushiknishant.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
