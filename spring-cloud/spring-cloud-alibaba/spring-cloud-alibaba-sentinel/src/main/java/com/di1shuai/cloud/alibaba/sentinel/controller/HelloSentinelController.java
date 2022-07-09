package com.di1shuai.cloud.alibaba.sentinel.controller;

import com.di1shuai.cloud.alibaba.sentinel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shea
 * @since 2022/7/7
 */
@RestController
public class HelloSentinelController {

    @Autowired
    StudentService studentService;


    @GetMapping("/hello")
    public String testSentinel() {
        return studentService.getMessage();
    }

}
