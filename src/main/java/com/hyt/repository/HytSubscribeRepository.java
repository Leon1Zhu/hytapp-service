package com.hyt.repository;

import com.hyt.domain.HytSubscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HytSubscribeRepository extends JpaRepository<HytSubscribe,Long>{
}
