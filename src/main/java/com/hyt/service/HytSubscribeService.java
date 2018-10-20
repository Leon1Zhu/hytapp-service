package com.hyt.service;

import com.hyt.repository.HytSubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HytSubscribeService {
    @Autowired
    private HytSubscribeRepository hytSubscribeRepository;


    public List getAllSubscribeService() {
        return hytSubscribeRepository.findAll();
    }
}
