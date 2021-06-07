package com.me.demo.repositories;

import com.me.demo.entities.LegoEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegoEmployeeRepository extends JpaRepository<LegoEmployeeEntity, Integer> {
    LegoEmployeeEntity findByUsername(String username);
}
