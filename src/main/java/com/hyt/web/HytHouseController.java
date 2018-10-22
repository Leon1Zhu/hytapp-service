package com.hyt.web;

import com.alibaba.fastjson.JSONObject;
import com.hyt.service.HytHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HytHouseController {
    @Autowired
    private HytHouseService hytHouseService;

    @GetMapping("/getHouseById")
    public ResponseEntity addSubscribe(@RequestParam String houseid){
        try {
            return ResponseEntity.ok().body(hytHouseService.getHouseById(houseid));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @GetMapping("/getSelectedHouse")
    public ResponseEntity getSelectedHouse(@RequestParam Map searchobj, @RequestParam int index, @RequestParam int length){
        try {
            Pageable pageable = new PageRequest(index,length);
            return ResponseEntity.ok().body(hytHouseService.searchHouse(new JSONObject(searchobj), pageable));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @GetMapping("/getLikeHouse")
    public ResponseEntity getLikeHouse( @RequestParam int index, @RequestParam int length){
        try {
            Pageable pageable = new PageRequest(index,length);
            return ResponseEntity.ok().body(hytHouseService.searchGuessLike(pageable));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}