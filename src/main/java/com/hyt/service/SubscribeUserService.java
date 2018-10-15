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

    public List findServerUserCount(String proName) {
        String last7 = "", pre1 = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.roll(Calendar.DATE, -7);//日期回滚7天
        last7 = sdf.format(lastDate.getTime());
        System.out.println(last7);

        lastDate.roll(Calendar.DATE, 8);//日期回滚7天
        pre1 = getPreData(7);
        System.out.println(pre1);
        String sql = "SELECT  a.*,COUNT(*) AS usercount FROM subscribe_user a  WHERE a.`subscribe_time`<='"+pre1+"' AND a.pro_name = '"+proName+"' AND a.`subscribe_time`>= '"+last7+"'   GROUP BY DATE_FORMAT(a.`subscribe_time`,'%Y-%m-%d')";
        List list = jdbcTemplate.queryForList(sql);

        return list;
    }


    public static String getPreData(int past) {
                 Calendar calendar = Calendar.getInstance();
                 calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) +past);
                 Date today = calendar.getTime();
                 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                 String result = format.format(today);
                 return result;
             }

}