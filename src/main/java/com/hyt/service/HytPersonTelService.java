package com.hyt.service;

import com.hyt.repository.HytPersonTelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HytPersonTelService {
    @Autowired
    private HytPersonTelRepository hytPersonTelRepository;
}
