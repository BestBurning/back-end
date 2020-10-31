package com.di1shuai.spring.annotation;

@RpcService("helloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello "+ name + " !";
    }

}
