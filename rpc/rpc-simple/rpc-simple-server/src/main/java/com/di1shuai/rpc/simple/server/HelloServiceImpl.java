package com.di1shuai.rpc.simple.server;

import com.di1shuai.rpc.server.RpcService;
import com.di1shuai.rpc.simple.api.HelloService;

@RpcService("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        String str = "hello " + name + " !";
        return str;
    }
}
