package com.yang.design.pattern.demo.observer.subscribe;

public interface Service {

    boolean addSubscribe(Observice observice); // 增加订阅者

    boolean removeSubscribe(Observice observice); // 删除订阅者

    void push(Object o); // 推送消息
}

