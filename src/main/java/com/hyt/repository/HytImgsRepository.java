package com.hyt.repository;

import com.hyt.domain.HytImgs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface HytImgsRepository  extends JpaRepository<HytImgs , String>{
//  @Transactional
//  int deleteById(String id);

  @Modifying
  @Transactional
  @Query("delete from HytImgs es where es.id = ?1")
  int deleteById(String id);
}
