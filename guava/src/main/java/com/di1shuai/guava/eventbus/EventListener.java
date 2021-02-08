package com.di1shuai.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author Shea
 * @date 2021-02-08
 * @description
 */
public class EventListener {

    /**
     * 监听 Integer 类型的消息
     */
    @Subscribe
    public void listenIntegerEvent(Integer param) {
        System.out.println("EventListener#listenInteger ->" + param);
    }

    /**
     * 监听 String 类型的消息
     */
    @Subscribe
    public void listenStringEvent(String param) {
        System.out.println("EventListener#listenString ->" + param);
    }


}
