package com.di1shuai.drools.boot.service;

import com.di1shuai.drools.boot.entity.Order;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Shea
 * @date 2021-02-03
 * @description
 */
@Service
public class OrderService {

    @Autowired
    KieContainer kieContainer;

    public Order getRealPrice(Order order){
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(order);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println(order);
        return order;
    }

}
