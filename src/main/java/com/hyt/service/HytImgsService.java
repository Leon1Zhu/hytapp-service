package com.hyt.service;

import com.hyt.repository.HytImgsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HytImgsService {
    @Autowired
    private HytImgsRepository hytImgsRepository;

    public void deleteImg(String imgId) throws Exception{
       hytImgsRepository.deleteById(imgId);
    }
}
