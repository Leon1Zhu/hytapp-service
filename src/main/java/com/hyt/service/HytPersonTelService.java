package com.hyt.service;

import com.hyt.domain.HytPersonTel;
import com.hyt.repository.HytPersonTelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HytPersonTelService {
    @Autowired
    private HytPersonTelRepository hytPersonTelRepository;

    public HytPersonTel addNewHytPersonalTel(HytPersonTel hytPersonTel) {
       HytPersonTel hytPersonTel1 = hytPersonTelRepository.save(hytPersonTel);
       return hytPersonTel;
    }
}
