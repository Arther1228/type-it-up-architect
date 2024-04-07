package com.yang.design.pattern.demo.observer.runoob;

public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}