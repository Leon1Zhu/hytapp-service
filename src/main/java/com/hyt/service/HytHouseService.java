package com.hyt.service;

import com.alibaba.fastjson.JSONObject;
import com.hyt.domain.HytHouse;
import com.hyt.repository.HytHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HytHouseService {
    @Autowired
    private HytHouseRepository hytHouseRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HytHouse getHouseById(String id) throws Exception{
        HytHouse hytHouse = hytHouseRepository.findOneById(id);
        if (hytHouse == null) {
            throw new Exception("不存在该楼盘信息");
        }
        return hytHouse;
    }

    public List searchHouse(JSONObject obj, Pageable pageable){
      String sqlTotal = "SELECT count(*) total FROM hyt_house a WHERE 1 = 1 ";
      String sql = "SELECT * FROM hyt_house a WHERE 1 = 1 ";
      HytHouseService hytHouseService = new HytHouseService();
      sql = hytHouseService.pjSql(sql, obj);
      sqlTotal = hytHouseService.pjSql(sqlTotal, obj);
      List result = jdbcTemplate.queryForList(sql);
      return result;
    }

    public String pjSql(String sql, JSONObject obj) {
        if (!"".equals(obj.getString("houseName"))) {
            sql += "  AND a.`house_name` = '"+obj.getString("houseName")+"' ";
        }

        if (!"".equals(obj.getString("regin"))) {
            sql += "  AND a.`regin` = '" +obj.getString("regin")+ "' ";
        }

        if (!"".equals(obj.getString("building_type"))) {
            sql += "  AND a.`building_type` = '" +obj.getString("building_type")+ "' ";
        }

        if (!"".equals(obj.getString("house_type"))) {
            sql += "  AND a.`housetype` = '" +obj.getString("house_type")+ "' ";
        }

        if (!"".equals(obj.getString("price"))) {
            String price = obj.getString("price");
            String[] prices = price.split("-");
            sql += "  AND a.`price` <= '" +prices[0]+ "' ";
            sql += "  AND a.`price` >= '" +prices[1]+ "' ";
        }
        return sql;
    }

    public List searchGuessLike() {
        return hytHouseRepository.findGuessLikeHouseByIsLike(true);
    }
}
