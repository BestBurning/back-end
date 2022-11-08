package com.di1shuai.drools.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shea
 * @date 2021-02-03
 * @description
 */
@RestController
public class HelloController {

    @GetMapping(path = "/hello")
    public String hello(@RequestParam String name){
        return "hello " + name;
    }


}
