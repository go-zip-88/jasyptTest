package com.jasyptTest.jasyptTest.controller;

import com.jasyptTest.jasyptTest.service.JasyptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/jasypt")
public class JasyptController {

    @Autowired
    private JasyptService jasyptService;

    @PostMapping(value = "/encoder")
    public String encoder(@RequestBody String str) {
        try {
            String result = jasyptService.encoder(str);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "실패";
        }

    }

    @PostMapping(value = "/decoder")
    public String decoder(@RequestBody String str) {
        try {
            String result = jasyptService.decoder(str);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "실패";
        }
    }
}
