package com.hyt.web;

import com.alibaba.fastjson.JSONObject;
import com.hyt.service.HytSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api")
public class HytSubscribeController {

    @Autowired
    private HytSubscribeService hytSubscribeService;

    @GetMapping("/getAllSubscribeByHouseId")
    public ResponseEntity getAllSubscribeByHouseId(@RequestParam int index,@RequestParam int length,@RequestParam String houseId){
        try {
            Pageable pageable = new PageRequest(index,length);
            return ResponseEntity.ok().body(hytSubscribeService.getAllSubscribeService(houseId, pageable));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @GetMapping("/getDashBoardInfo")
    public ResponseEntity addgetAllSubscribeSubscribe(){
        try {
            JSONObject jo = new JSONObject();
            jo.put("allSubscribe", hytSubscribeService.getAllSubScribe());
            jo.put("weekSubscribe", hytSubscribeService.findWeekSubscribe());
            return ResponseEntity.ok().body(jo);
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }


    @GetMapping("/subscribe-get-chart-count")
    public ResponseEntity getchartCount(){
        List list = hytSubscribeService.findServerUserCount();
        try {
            return ResponseEntity.ok().body(list);
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @PostMapping("/addSubscribe")
    public ResponseEntity addSubscribe(@RequestParam String phone,@RequestParam String name,@RequestParam String proId, @RequestParam String type, @RequestParam String origin){
        try {
            return ResponseEntity.ok().body(hytSubscribeService.addSubscribe(phone,name, proId, type, origin));
        }catch (Exception e){
            e.printStackTrace();
            ExecResult er=new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
