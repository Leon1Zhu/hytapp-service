package com.hyt.repository;

import com.hyt.domain.HytHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HytHouseRepository extends JpaRepository<HytHouse,String> {
    Page<HytHouse> findByLike(Boolean Islike, Pageable pageable);
}
