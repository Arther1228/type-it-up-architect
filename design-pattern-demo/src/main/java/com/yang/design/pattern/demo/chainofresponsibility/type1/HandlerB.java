package com.yang.design.pattern.demo.chainofresponsibility.type1;

public class HandlerB extends AbstractHandler {
  @Override
  public void handle() {
    // do something
    System.out.println("handler b");

    if (next != null) {
      next.handle();
    }
  }
}