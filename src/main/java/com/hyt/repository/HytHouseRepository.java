package com.hyt.repository;

import com.hyt.domain.HytHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HytHouseRepository extends JpaRepository<HytHouse,Long> {
    HytHouse findOneById(String id);

    List findGuessLikeHouseByIsLike(Boolean islike);
}
