package com.di1shuai.rpc.simple.server;

import com.di1shuai.rpc.registry.ServiceRegistry;
import com.di1shuai.rpc.server.RpcServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = "com.di1shuai.rpc.simple.server")
public class HelloServer {
    public static final Logger logger = LoggerFactory.getLogger(HelloServer.class);

    private static final String zk = "server01:2181";

    private static final String server = "192.168.0.26:20008";

    @Bean
    public RpcServer rpcServer(){
        return new RpcServer(server,new ServiceRegistry(zk));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloServer.class);
    }

}
