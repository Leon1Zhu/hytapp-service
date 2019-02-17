package com.hyt.repository;

import com.hyt.domain.HytHouseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface HytHouseTypeRepository extends JpaRepository<HytHouseType, String> {
    @Modifying
    @Transactional
    @Query("delete from HytHouseType es where es.id = ?1")
    int deleteById(String id);
}
