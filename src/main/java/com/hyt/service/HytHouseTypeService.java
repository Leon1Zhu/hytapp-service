package com.hyt.service;

import com.hyt.domain.HytHouseType;
import com.hyt.repository.HytHouseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.UUID;

@Service
public class HytHouseTypeService {
    @Value("${imgPath}")
    private String imgPath;
    @Autowired
    private HytHouseTypeRepository hytHouseTypeRepository;
    public void deleteHouseType(String typeId) throws Exception{
        HytHouseType hytHouseType = hytHouseTypeRepository.findOne(typeId);
        hytHouseTypeRepository.deleteById(typeId);
        HytHouseTypeService.delFile(imgPath, hytHouseType.getTypeImg());
    }

    public HytHouseType addNewType(HytHouseType hytHouseType) {
        String id = UUID.randomUUID().toString();
        hytHouseType.setCreateTime(new Date());
        hytHouseType.setId(id);
        hytHouseType.setTypeId(id);
        hytHouseType.setHot(true);
        return hytHouseTypeRepository.save(hytHouseType);
    }

    public static void delFile(String path,String filename){
        File file=new File(path+"/"+filename);
        if(file.exists()&&file.isFile())
            file.delete();
    }
}
