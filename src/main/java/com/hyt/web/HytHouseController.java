package com.hyt.web;

import com.alibaba.fastjson.JSONObject;
import com.hyt.domain.HytHouse;
import com.hyt.service.HytHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.UUID;

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

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile fileUpload){
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
//        //获取文件后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        //重新生成文件名
//        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
        String filePath = "C:/dummyPath/";
        try {
            //将图片保存到static文件夹里
            fileUpload.transferTo(new File(filePath+fileName));
            return ResponseEntity.ok().body(filePath + fileName);

        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @PostMapping("/addNewHouse")
    public ResponseEntity addNewHouse(@RequestBody HytHouse hytHouse1) {
        try {
            System.out.println(hytHouse1);
            return ResponseEntity.ok().body(hytHouseService.addNewHouse(hytHouse1));

        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

}
