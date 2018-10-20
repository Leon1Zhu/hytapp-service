package com.hyt.web;

import com.hyt.service.HytHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HytHouseController {
    @Autowired
    private HytHouseService hytHouseService;

    @GetMapping("/getHouseById")
    public ResponseEntity addSubscribe(@RequestParam String id){
        try {
            return ResponseEntity.ok().body(hytHouseService.getHouseById(id));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
