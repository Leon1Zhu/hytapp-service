package com.hyt.service;

import com.hyt.domain.SubscribeUser;
import com.hyt.repository.SubscribeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuliang on 2017/6/9.
 */
@Service
public class SubscribeUserService {

    @Autowired
    private SubscribeUserRepository subscribeUserRepository;

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public SubscribeUser addSubscribe(String phone, String name,String proName) throws Exception {
        SubscribeUser subscribeUser = subscribeUserRepository.findUserByUserPhoneAndProName(phone,proName);
        if (subscribeUser != null) {
            throw new Exception("您已经预约过该楼盘！");
        }
        subscribeUser = new SubscribeUser();
        subscribeUser.setOrigin("0");
        subscribeUser.setSubscribeTime(new Date());
        subscribeUser.setUserName(name);
        subscribeUser.setProName(proName);
        subscribeUser.setUserPhone(phone);
        return subscribeUserRepository.save(subscribeUser);
    }


    public Page<SubscribeUser> findAllUser(String proName,Pageable pageable) {
        return subscribeUserRepository.findUserByProNameOrderBySubscribeTimeDesc(proName,pageable);
    }



}