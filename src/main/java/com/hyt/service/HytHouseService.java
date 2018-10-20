package com.hyt.service;

import com.hyt.domain.HytHouse;
import com.hyt.repository.HytHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HytHouseService {
    @Autowired
    private HytHouseRepository hytHouseRepository;

    public HytHouse getHouseById(String id) throws Exception{
        HytHouse hytHouse = hytHouseRepository.findOneById(id);
        if (hytHouse == null) {
            throw new Exception("不存在该楼盘信息");
        }
        return hytHouse;
    }
}
