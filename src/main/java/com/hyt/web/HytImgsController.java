package com.hyt.web;

import com.hyt.service.HytImgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HytImgsController {
    @Autowired
    private HytImgsService hytImgsService;
}
