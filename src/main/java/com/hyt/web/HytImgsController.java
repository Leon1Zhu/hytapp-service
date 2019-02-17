package com.hyt.web;

import com.hyt.domain.HytImgs;
import com.hyt.service.HytImgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HytImgsController {
    @Autowired
    private HytImgsService hytImgsService;

    @PostMapping("/deleteImgs")
    public ResponseEntity deleteImgs( @RequestParam String id) {
        try {
          hytImgsService.deleteImg(id);
          return ResponseEntity.ok().body(false);

        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false, "图片删除失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }

    @PostMapping("/addImgs")
    public ResponseEntity addImgs(@RequestBody HytImgs img) {
        try {

            return ResponseEntity.ok().body(hytImgsService.addNewImgs(img));

        }catch (Exception e){
            e.printStackTrace();
            ExecResult er = new ExecResult(false, "图片增加失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
        }
    }
}
