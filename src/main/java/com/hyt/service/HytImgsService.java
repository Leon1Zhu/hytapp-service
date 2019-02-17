package com.hyt.service;

import com.hyt.domain.HytImgs;
import com.hyt.repository.HytImgsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.UUID;

@Service
public class HytImgsService {
    @Value("${imgPath}")
    private String imgPath;
    @Autowired
    private HytImgsRepository hytImgsRepository;

    public void deleteImg(String imgId) throws Exception{
       HytImgs hytImgs = hytImgsRepository.findOne(imgId);
       hytImgsRepository.deleteById(imgId);
       HytImgsService.delFile(imgPath, hytImgs.getImgsUrl());
    }

    public HytImgs addNewImgs(HytImgs imgs) {
        String id = UUID.randomUUID().toString();
        imgs.setCreateTime(new Date());
        imgs.setId(id);
        imgs.setImgsId(id);
        imgs.setTop(false);
        return hytImgsRepository.save(imgs);
    }

    public static void delFile(String path,String filename){
        File file=new File(path+"/"+filename);
        if(file.exists()&&file.isFile())
            file.delete();
    }
}
