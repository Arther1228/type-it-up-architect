package com.yang.design.pattern.demo.chainofresponsibility.type2;

// 3、定义处理器B
public class HandlerB implements IHandler {
  @Override
  public void handle() {
    // do something
    System.out.println("handler b");
  }
}