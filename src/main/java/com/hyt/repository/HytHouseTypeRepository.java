package com.hyt.repository;

import com.hyt.domain.HytHouseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HytHouseTypeRepository extends JpaRepository<HytHouseType, String> {
    void deleteById(String id);
}
