package com.hyt.service;

import com.hyt.domain.HytHouse;
import com.hyt.domain.HytPersonTel;
import com.hyt.repository.HytHouseRepository;
import com.hyt.repository.HytPersonTelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HytPersonTelService {
    @Autowired
    private HytPersonTelRepository hytPersonTelRepository;

    @Autowired
    private HytHouseRepository hytHouseRepository;

    public HytPersonTel addNewHytPersonalTel(String telOrigin, String telNumber, Date telTime, String houseId) throws Exception{
       HytHouse hytHouse = hytHouseRepository.findOne(houseId);
       if (hytHouse == null) {
         throw new Exception("不存在的项目");
       }
       HytPersonTel hytPersonTel = new HytPersonTel();
       hytPersonTel.setHytHouse(hytHouse);
       hytPersonTel.setTelNumber(telNumber);
       hytPersonTel.setTelOrigin(telOrigin);
       hytPersonTel.setTemTime(telTime);
       hytPersonTel.setId(UUID.randomUUID().toString());
       return hytPersonTelRepository.save(hytPersonTel);
    }

    public Page<HytPersonTel> getAllTelService(String houseId, Pageable pageable) throws Exception{
        if (!"All".equals(houseId)) {
            HytHouse hytHouse = hytHouseRepository.findOne(houseId);
            if (hytHouse == null) {
                throw new Exception("没有该楼盘信息");
            }
            return hytPersonTelRepository.findHHytPersonTelByHytHouseOrderByTelTimeDesc(hytHouse, pageable);
        } else {
            return hytPersonTelRepository.findHytPersonTelByOrderByTelTimeDesc(pageable);
        }

    }
}
