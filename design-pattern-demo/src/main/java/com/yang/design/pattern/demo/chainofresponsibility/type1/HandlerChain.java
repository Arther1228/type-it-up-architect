package com.yang.design.pattern.demo.chainofresponsibility.type1;

public class HandlerChain {
  // 通过链表的形式保存责任链
  private AbstractHandler head = null;
  private AbstractHandler tail = null;
 
  public void addHandler(AbstractHandler handler) {
    handler.setSuccessor(null);
 
    if (head == null) {
      head = handler;
      tail = handler;
      return;
    }
 
    tail.setSuccessor(handler);
    tail = handler;
  }
 
  public void handle() {
    if (head != null) {
      head.handle();
    }
  }
}