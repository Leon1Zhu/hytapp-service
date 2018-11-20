package com.hyt.repository;

import com.hyt.domain.HytHouse;
import com.hyt.domain.HytPersonTel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HytPersonTelRepository extends JpaRepository<HytPersonTel,String>{
    Page<HytPersonTel> findHytPersonTelByOrderByTelTimeDesc(Pageable pageable);
    Page<HytPersonTel> findHHytPersonTelByHytHouseOrderByTelTimeDesc(HytHouse hytHouse, Pageable pageable);
}
