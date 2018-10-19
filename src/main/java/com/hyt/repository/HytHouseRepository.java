package com.hyt.repository;

import com.hyt.domain.HytHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HytHouseRepository extends JpaRepository<HytHouse,Long> {
}
