package com.hyt.web;

import com.hyt.domain.HytPersonTel;
import com.hyt.service.HytPersonTelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/api")
public class HytPersonTelController {

    @Autowired
    private HytPersonTelService hytPersonTelService;

    @PostMapping("/addNewPersonTel")
    public ResponseEntity addNewPersonTel(@RequestParam String telOrigin, @RequestParam String telNumber, @RequestParam String houseId){
        try {
            return ResponseEntity.ok().body(hytPersonTelService.addNewHytPersonalTel(telOrigin, telNumber, new Date(), houseId));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @GetMapping("/getPresonTel")
    public ResponseEntity getPresonTel(@RequestParam int index,@RequestParam int length,@RequestParam String houseId){
        try {
            Pageable pageable = new PageRequest(index,length);
            return ResponseEntity.ok().body(hytPersonTelService.getAllTelService(houseId, pageable));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
