package com.di1shuai.drools.test;

import com.di1shuai.drools.entity.Order;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

/**
 * @author Shea
 * @date 2021-01-30
 * @description
 */
public class OrderRuleTest {

    @Test
    public void orderRule() {
        // 获取KieService
        KieServices kieServices = KieServices.Factory.get();
        // 获取 Container
        KieContainer container = kieServices.getKieClasspathContainer();
        // 创建会话
        KieSession kieSession = container.newKieSession();

        List<Order> list = List.of(
                new Order().setOriginalPrice(50d),
                new Order().setOriginalPrice(150d),
                new Order().setOriginalPrice(250d),
                new Order().setOriginalPrice(450d)
        );
        list.forEach(kieSession::insert);

        // 匹配规则
        kieSession.fireAllRules();

        // 释放资源
        kieSession.dispose();
        list.forEach(System.out::println);

    }


}
