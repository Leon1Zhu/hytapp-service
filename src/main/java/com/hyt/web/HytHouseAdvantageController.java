package com.hyt.web;

import com.hyt.domain.HytHouse;
import com.hyt.domain.HytHouseAdvantage;
import com.hyt.service.HytHouseAdvantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HytHouseAdvantageController {

    @Autowired HytHouseAdvantageService hytHouseAdvantageService;
    @PostMapping("/addNewHouseAdvantage")
    public ResponseEntity addNewHouse(@RequestBody HytHouseAdvantage hytHouseAdvantage) {
        try {
            return ResponseEntity.ok().body(hytHouseAdvantageService.addNewAdvantage(hytHouseAdvantage));

        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
