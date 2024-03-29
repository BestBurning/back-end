package com.di1shuai.cloud.api.service;

import com.di1shuai.cloud.api.model.User;
import com.di1shuai.cloud.api.service.fallback.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author: Bruce
 * @date: 2019-11-23
 * @description:
 */
@FeignClient(name = "PROVIDER-USER",fallbackFactory = UserServiceFallbackFactory.class)
public interface UserService{

    @PostMapping(path = "/user")
    boolean save(User user);

    @GetMapping(path = "/user/{id}")
    User getById(@PathVariable("id") Long id);

    @GetMapping(path = "/user/list")
    List<User> list();
}
