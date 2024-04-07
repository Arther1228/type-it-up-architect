package com.yang.design.pattern.demo.chainofresponsibility.type1;

public class Application {
    public static void main(String[] args) {
        // 构建责任链并添加处理器
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());

        // 责任链负责触发
        chain.handle();
    }
}