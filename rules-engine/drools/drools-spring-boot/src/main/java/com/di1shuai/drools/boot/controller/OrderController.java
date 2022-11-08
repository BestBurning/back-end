package com.di1shuai.drools.boot.controller;

import com.di1shuai.drools.boot.entity.Order;
import com.di1shuai.drools.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shea
 * @date 2021-02-03
 * @description
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/real")
    public Order getRealPrice(@RequestBody Order order) {
        return orderService.getRealPrice(order);
    }


}
