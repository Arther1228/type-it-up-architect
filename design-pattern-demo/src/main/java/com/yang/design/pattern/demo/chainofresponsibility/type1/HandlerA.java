package com.yang.design.pattern.demo.chainofresponsibility.type1;

public class HandlerA extends AbstractHandler {
  @Override
  public void handle() {
    // do something
    System.out.println("handler a");
 
    if (next != null) {
      next.handle();
    }
  }
}