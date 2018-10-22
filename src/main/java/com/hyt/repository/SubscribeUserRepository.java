package com.hyt.repository;

import com.hyt.domain.SubscribeUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by zhuliang on 2017/6/9.
 */
@Repository
public interface SubscribeUserRepository extends JpaRepository<SubscribeUser,String>{
    SubscribeUser findUserByUserPhoneAndProName(String phone,String proName);

    Page<SubscribeUser> findUserByProNameOrderBySubscribeTimeDesc(String proName,Pageable pageable);




}
