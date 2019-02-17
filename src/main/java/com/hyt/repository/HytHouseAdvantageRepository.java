package com.hyt.repository;

import com.hyt.domain.HytHouseAdvantage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface HytHouseAdvantageRepository extends JpaRepository<HytHouseAdvantage, String> {
    @Modifying
    @Transactional
    @Query("delete from HytHouseAdvantage es where es.id = ?1")
    int deleteById(String id);
}
