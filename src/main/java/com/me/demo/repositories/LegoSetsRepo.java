package com.me.demo.repositories;

import com.me.demo.entities.LegoSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegoSetsRepo extends JpaRepository<LegoSetEntity, Integer> {
    LegoSetEntity findByName(String name);
    LegoSetEntity findByMinimumAgeGreaterThan(Integer minimumAge);
    LegoSetEntity findByMinimumAgeLessThan(Integer maximumAge);
}
