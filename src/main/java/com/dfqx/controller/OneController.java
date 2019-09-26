package com.dfqx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Zuul/")
public class OneController {
@RequestMapping("/hello")
public String getHello(){
        return "hello";
    }
}
