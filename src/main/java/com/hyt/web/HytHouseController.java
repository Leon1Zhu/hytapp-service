package com.hyt.web;

import com.alibaba.fastjson.JSONObject;
import com.hyt.service.HytHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            Pageable pageable = new PageRequest(Integer.parseInt(searchobj.get("index").toString()), Integer.parseInt(searchobj.get("length").toString()));
            return ResponseEntity.ok().body(hytHouseService.searchHouse(JSONObject.parseObject(searchobj.get("searchobj").toString()), pageable));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @GetMapping("/getLikeHouse")
    public ResponseEntity getLikeHouse( Pageable pageable){
        try {
            return ResponseEntity.ok().body(hytHouseService.searchGuessLike(pageable));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @GetMapping("/getGoodHouse")
    public ResponseEntity getGoodHouse( Pageable pageable){
        try {
            return ResponseEntity.ok().body(hytHouseService.searchGoodHouse(pageable));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @GetMapping("/getAllHouse")
    public ResponseEntity getAllHouse(){
        try {
            return ResponseEntity.ok().body(hytHouseService.getAllHouse());
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam String loginName, @RequestParam String password) {
        try {
            if ("hytS.1288".equals(loginName) && "hytS.1288".equals(password)) {
                return ResponseEntity.ok().body(true);
            } else {
                return ResponseEntity.ok().body(false);
            }

        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
