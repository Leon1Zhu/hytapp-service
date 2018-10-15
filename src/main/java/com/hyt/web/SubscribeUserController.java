package com.hyt.web;

import com.hyt.domain.SubscribeUser;
import com.hyt.service.SubscribeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhuliang on 2017/6/9.
 */
@RestController
@RequestMapping("/api")
public class SubscribeUserController {

    @Autowired
    private SubscribeUserService subscribeUserService;
    @PostMapping("/subscribe-users")
    public ResponseEntity addSubscribe(@RequestParam String phone,@RequestParam String name,@RequestParam String proName){
      try {
        return ResponseEntity.ok().body(subscribeUserService.addSubscribe(phone,name,proName));
      }catch (Exception e){
        e.printStackTrace();
        ExecResult er=new ExecResult(false,e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
      }
    }

    @GetMapping("/subscribe-get-table-user")
    public ResponseEntity getAllUser(@RequestParam int index,@RequestParam int length,@RequestParam String proName){
      try {
          Pageable pageable = new PageRequest(index,length);
          Page<SubscribeUser> subscribeUserPage = subscribeUserService.findAllUser(proName,pageable);
        return ResponseEntity.ok().body(subscribeUserPage);
      }catch (Exception e){
        e.printStackTrace();
        ExecResult er=new ExecResult(false,e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
      }
    }

    @GetMapping("/subscribe-get-chart-count")
    public ResponseEntity getchartCount(@RequestParam String proName){
        List list = subscribeUserService.findServerUserCount(proName);
      try {
        return ResponseEntity.ok().body(list);
      }catch (Exception e){
        e.printStackTrace();
        ExecResult er=new ExecResult(false,e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
      }
    }
}
