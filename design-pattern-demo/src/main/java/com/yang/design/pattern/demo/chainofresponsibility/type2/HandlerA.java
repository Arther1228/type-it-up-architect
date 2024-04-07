package com.yang.design.pattern.demo.chainofresponsibility.type2;

// 2、定义处理器A
public class HandlerA implements IHandler {
  @Override
  public void handle() {
    // do something
    System.out.println("handler a");
  }
}