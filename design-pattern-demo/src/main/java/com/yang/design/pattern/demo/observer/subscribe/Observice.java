package com.yang.design.pattern.demo.observer.subscribe;

public interface Observice {

    void gotIt(Object s); // 收到消息后的动作

    String getId();

    String getName();
}

