package com.hyt.service;

import com.hyt.domain.HytHouse;
import com.hyt.domain.HytSubscribe;
import com.hyt.repository.HytHouseRepository;
import com.hyt.repository.HytSubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HytSubscribeService {
    @Autowired
    private HytSubscribeRepository hytSubscribeRepository;
    @Autowired
    private HytHouseRepository hytHouseRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Page<HytSubscribe> getAllSubscribeService(String houseId, Pageable pageable) throws Exception{
        if (!"All".equals(houseId)) {
            HytHouse hytHouse = hytHouseRepository.findOne(houseId);
            if (hytHouse == null) {
                throw new Exception("没有该楼盘信息");
            }
            return hytSubscribeRepository.findHytSubscribeByHytHouseOrderByOrderTimeDesc(hytHouse, pageable);
        } else {
            return hytSubscribeRepository.findHytSubscribeByOrderByOrderTimeDesc(pageable);
        }

    }

    public List<HytSubscribe> getAllSubScribe() {
        return hytSubscribeRepository.findAll();
    }

    public List findServerUserCount() {
        String last7 = "", pre1 = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.roll(Calendar.DATE, -7);//日期回滚7天
        last7 = sdf.format(lastDate.getTime());
        lastDate.roll(Calendar.DATE, 8);//日期回滚7天
        pre1 = getPreData(7);
        String sql = "SELECT  a.*,COUNT(*) AS usercount FROM hyt_subscribe a  WHERE a.`order_time`<='"+pre1+"' AND a.`order_time`>= '"+last7+"'   GROUP BY DATE_FORMAT(a.`order_time`,'%Y-%m-%d')";
        List list = jdbcTemplate.queryForList(sql);
        return list;
    }

    public List findWeekSubscribe() {
        String sql = "SELECT  a.*,COUNT(*) AS usercount FROM hyt_subscribe a  WHERE  a.`order_time`>= '"+getTimesWeekmorning()+"'   GROUP BY DATE_FORMAT(a.`order_time`,'%Y-%m-%d')";
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

    // 获得本周一0点时间
    public static String getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(cal.getTime());
        return result;
    }

    public HytSubscribe addSubscribe(String phone, String name , String houseId, String type, String origin) throws Exception{
        HytHouse hytHouse = hytHouseRepository.findOne(houseId);
        if (hytHouse == null) {
            throw new Exception("没有该楼盘信息");
        }
        HytSubscribe hytSubscribe = hytSubscribeRepository.findHytSubscribeByPersonNameAndPersonTelAndHytHouseAndType(name, phone, hytHouse, type);
        if (hytSubscribe != null) {
            throw new Exception("您已经预约过该楼盘啦");
        }

        hytSubscribe = new HytSubscribe();
        hytSubscribe.setHytHouse(hytHouse);
        hytSubscribe.setOrigin(origin);
        hytSubscribe.setPersonName(name);
        hytSubscribe.setPersonTel(phone);
        hytSubscribe.setType(type);
        hytSubscribe.setOrderTime(new Date());
        hytSubscribe.setId(UUID.randomUUID().toString());
        if ("预约看房".equals(type)) {
            int orderNumber= Integer.parseInt(hytHouse.getHouseOrderNumber());
            hytHouse.setHouseOrderNumber(String.valueOf(orderNumber + 1));
            hytHouseRepository.save(hytHouse);
        }
        return hytSubscribeRepository.save(hytSubscribe);
    }

}
