package com.yang.design.pattern.demo.chainofresponsibility.type2;

/**
 * https://mp.weixin.qq.com/s/IvPEvf1Jn3Xejh8TbH0Inw
 */
// 5、整体构建责任链添加处理器并进行驱动
public class Application {
  public static void main(String[] args) {
    HandlerChain chain = new HandlerChain();
    chain.addHandler(new HandlerA());
    chain.addHandler(new HandlerB());
    chain.handle();
  }
}