package com.hyt.repository;

import com.hyt.domain.HytPersonTel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HytPersonTelRepository extends JpaRepository<HytPersonTel,String>{
}
