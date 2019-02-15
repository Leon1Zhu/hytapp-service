package com.hyt.service;

import com.alibaba.fastjson.JSONObject;
import com.hyt.domain.HytHouse;
import com.hyt.repository.HytHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class HytHouseService {
    @Autowired
    private HytHouseRepository hytHouseRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HytHouse getHouseById(String id) throws Exception{
        HytHouse hytHouse = hytHouseRepository.findOne(id);
        if (hytHouse == null) {
            throw new Exception("不存在该楼盘信息");
        }
        return hytHouse;
    }

    public JSONObject searchHouse(JSONObject obj, Pageable pageable){
      int start = pageable.getPageNumber() * pageable.getPageSize();
      int end =  start + pageable.getPageSize();
      JSONObject result = new JSONObject();
      String sql = "SELECT a.* FROM hyt_house a  LEFT JOIN hyt_house_type b  ON a.`id` = b.`hyt_house_id` WHERE 1 = 1  ";
      HytHouseService hytHouseService = new HytHouseService();
      sql = hytHouseService.pjSql(sql, obj);
      sql += " GROUP BY a.id ";
      List totalResult = jdbcTemplate.queryForList(sql);
      sql += " Limit "+start+", "+end+" ";
      List resultList = jdbcTemplate.queryForList(sql);
      result.put("result", resultList);
      result.put("total", totalResult.size());
      return result;
    }

    public String pjSql(String sql, JSONObject obj) {
        if (!(null == obj.getString("houseName") || "".equals( obj.getString("houseName")))) {
            sql += "  AND a.`house_name` like '%"+obj.getString("houseName")+"%' ";
        }

        if (!(null== obj.getJSONObject("regin"))) {
            sql += "  AND a.`regin` = '" +obj.getJSONObject("regin").getString("data")+ "' ";
        }

        if (!(null == obj.getJSONObject("building_type"))) {
            String build_type = obj.getJSONObject("building_type").getString("data");
            if ("优质房源".equals(build_type)) {
                sql += "  AND a.`is_highquality` = 1 ";
            } else {
                sql += "  AND a.`building_type` like '%"+build_type+"%' ";
            }
        }

        if (!(null == obj.getJSONObject("house_type"))) {
            sql += "  AND b.`type_direction` like '%"+obj.getJSONObject("house_type").getString("data")+"%' ";
        }
        if (! (null == obj.getString("price") || "不限".equals(obj.getJSONObject("price").getString("data")))) {
            String price = obj.getJSONObject("price").getString("data");
            String[] prices = price.split("-");
            sql += "  AND a.`price` >= " +prices[0]+ " ";
            sql += "  AND a.`price` <= " +prices[1]+ " ";
        }
        return sql;
    }

    public Page searchGuessLike(Pageable pageable) {
        return hytHouseRepository.findByLike(true, pageable);
    }

    public Page searchGoodHouse(Pageable pageable) {
        return hytHouseRepository.findByIsRecommend(true, pageable);
    }

    public List<HytHouse> getAllHouse() {
        return hytHouseRepository.findAllByOrderByCreateTime();
    }

    public HytHouse addNewHouse(HytHouse hytHouse) {
        hytHouse.setId(UUID.randomUUID().toString());
        hytHouse.setOpenTime(new Date());
        hytHouse.setCreateTime(new Date());
        hytHouse.setRedpacket("2000元");
        hytHouse.setRedpacketDesc("优惠信息请致电售楼部咨询");
        return hytHouseRepository.save(hytHouse);
    }
}
