package com.hyt.repository;

import com.hyt.domain.HytHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface HytHouseRepository extends JpaRepository<HytHouse,String> {
    List<HytHouse> findAllByOrderByCreateTime();
    Page<HytHouse> findByLike(Boolean Islike, Pageable pageable);
    Page<HytHouse> findByIsRecommend(Boolean isRecommend, Pageable pageable);

    @Modifying
    @Transactional
    @Query("delete from HytHouse es where es.id = ?1")
    int deleteById(String id);
}
