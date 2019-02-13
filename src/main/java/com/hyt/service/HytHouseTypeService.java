package com.hyt.service;

import com.hyt.repository.HytHouseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HytHouseTypeService {
    @Autowired
    private HytHouseTypeRepository hytHouseTypeRepository;
    public void deleteHouseType(String typeId) throws Exception{
        hytHouseTypeRepository.deleteById(typeId);
    }
}
