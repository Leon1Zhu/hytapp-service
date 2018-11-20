package com.hyt.repository;

import com.hyt.domain.HytHouse;
import com.hyt.domain.HytSubscribe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HytSubscribeRepository extends JpaRepository<HytSubscribe,String>{
    Page<HytSubscribe> findHytSubscribeByOrderByOrderTimeDesc(Pageable pageable);
    Page<HytSubscribe> findHytSubscribeByHytHouseOrderByOrderTimeDesc(HytHouse hytHouse, Pageable pageable);
}
