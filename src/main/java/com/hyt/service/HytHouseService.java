package com.hyt.service;

import com.hyt.repository.HytHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HytHouseService {
    @Autowired
    private HytHouseRepository hytHouseRepository;
}
