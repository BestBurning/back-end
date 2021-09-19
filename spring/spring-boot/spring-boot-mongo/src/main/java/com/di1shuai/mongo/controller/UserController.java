package com.di1shuai.mongo.controller;

import com.di1shuai.mongo.dao.CustomerRepository;
import com.di1shuai.mongo.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: shea
 * @date: 2021/8/12
 * @description:
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getCustomerList(){
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.insert(customer);
    }
}
