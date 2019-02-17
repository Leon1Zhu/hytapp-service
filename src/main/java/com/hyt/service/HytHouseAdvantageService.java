package com.hyt.service;

import com.hyt.domain.HytHouseAdvantage;
import com.hyt.repository.HytHouseAdvantageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class HytHouseAdvantageService {
    @Autowired
    HytHouseAdvantageRepository hytHouseAdvantageRepository;
    public HytHouseAdvantage addNewAdvantage(HytHouseAdvantage hytHouseAdvantage) {
        String id = UUID.randomUUID().toString();
        hytHouseAdvantage.setId(id);
        hytHouseAdvantage.setAdvatageId(id);
        hytHouseAdvantage.setCreateTime(new Date());
         return hytHouseAdvantageRepository.save(hytHouseAdvantage);
    }
}
