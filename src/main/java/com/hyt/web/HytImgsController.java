package com.hyt.web;

import com.hyt.service.HytImgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HytImgsController {
    @Autowired
    private HytImgsService hytImgsService;

    @PostMapping("/deleteImgs")
    public ResponseEntity login(@RequestParam String houseId, @RequestParam String id) {
        try {

        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
