package com.hyt.repository;

import com.hyt.domain.HytImgs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HytImgsRepository  extends JpaRepository<HytImgs , String>{

}
