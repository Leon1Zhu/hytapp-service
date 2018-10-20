package com.hyt.web;

import com.hyt.service.HytSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HytSubscribeController {

    @Autowired
    private HytSubscribeService hytSubscribeService;

    @GetMapping("/getAllSubscribe")
    public ResponseEntity addSubscribe(){
        try {
            return ResponseEntity.ok().body(hytSubscribeService.getAllSubscribeService());
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
