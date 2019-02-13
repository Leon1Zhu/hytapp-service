package com.hyt.web;

import com.hyt.service.HytHouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HytHouseTypeController {
    @Autowired
    private HytHouseTypeService hytHouseTypeService;
    @PostMapping("/deleteTypeById")
    public ResponseEntity deleteTypeById(@RequestParam String id) {
        try {
            hytHouseTypeService.deleteHouseType(id);
            return ResponseEntity.ok().body(false);

        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false, "户型删除失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
