package com.hyt.service;

import com.hyt.domain.HytImgs;
import com.hyt.repository.HytImgsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class HytImgsService {
    @Autowired
    private HytImgsRepository hytImgsRepository;

    public void deleteImg(String imgId) throws Exception{
       hytImgsRepository.deleteById(imgId);
    }

    public HytImgs addNewImgs(HytImgs imgs) {
        String id = UUID.randomUUID().toString();
        imgs.setCreateTime(new Date());
        imgs.setId(id);
        imgs.setImgsId(id);
        return hytImgsRepository.save(imgs);
    }
}
