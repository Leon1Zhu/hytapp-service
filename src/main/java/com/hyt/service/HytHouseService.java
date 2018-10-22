package com.hyt.service;

import com.alibaba.fastjson.JSONObject;
import com.hyt.domain.HytHouse;
import com.hyt.repository.HytHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
      String sqlTotal = "SELECT count(*) total FROM hyt_house a WHERE 1 = 1 ";
      String sql = "SELECT * FROM hyt_house a WHERE 1 = 1 ";
      HytHouseService hytHouseService = new HytHouseService();
      sql = hytHouseService.pjSql(sql, obj);
      sql += " Limit "+start+", "+end+" ";
      sqlTotal = hytHouseService.pjSql(sqlTotal, obj);
      List resultList = jdbcTemplate.queryForList(sql);
      Map totalMap = jdbcTemplate.queryForMap(sqlTotal);
      result.put("result", resultList);
      result.put("total", totalMap);
      return result;
    }

    public String pjSql(String sql, JSONObject obj) {
        if (!(null == obj.getString("houseName"))) {
            sql += "  AND a.`house_name` = '"+obj.getString("houseName")+"' ";
        }

        if (!(null== obj.getString("regin"))) {
            sql += "  AND a.`regin` = '" +obj.getString("regin")+ "' ";
        }

        if (!(null == obj.getString("building_type"))) {
            sql += "  AND a.`building_type` = '" +obj.getString("building_type")+ "' ";
        }

        if (!(null == obj.getString("house_type"))) {
            sql += "  AND a.`housetype` = '" +obj.getString("house_type")+ "' ";
        }

        if (! (null == obj.getString("price")) ) {
            String price = obj.getString("price");
            String[] prices = price.split("-");
            sql += "  AND a.`price` <= '" +prices[0]+ "' ";
            sql += "  AND a.`price` >= '" +prices[1]+ "' ";
        }
        return sql;
    }

    public Page searchGuessLike(Pageable pageable) {
        return hytHouseRepository.findByLike(true, pageable);
    }
}
