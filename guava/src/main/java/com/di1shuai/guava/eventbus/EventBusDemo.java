package com.di1shuai.guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * @author Shea
 * @date 2021-02-08
 * @description
 */
public class EventBusDemo {

    public static void main(String[] args) {
        //创建EventBus
        EventBus eventBus = new EventBus();

        eventBus.register(new EventListener());

        eventBus.post(1);
        eventBus.post(2);
        eventBus.post("3");
    }

}
