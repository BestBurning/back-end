package com.di1shuai.cloud.provider.controller;

import com.di1shuai.cloud.api.model.User;
import com.di1shuai.cloud.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Bruce
 * @date: 2019-11-22
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean add(@RequestBody User user)
    {
        return userService.save(user);
    }

    @GetMapping(path = "/{id}")
    public User getById(@PathVariable("id") Long id)
    {
        return userService.getById(id);
    }

    @GetMapping(value = "/list")
    public List<User> list() { return userService.list(); }

}
