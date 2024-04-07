package com.yang.design.pattern.demo.chainofresponsibility.type2;

import java.util.ArrayList;
import java.util.List;

// 4、构建责任链并添加处理器
public class HandlerChain {
  // 通过数组的形式保存处理器
  private List<IHandler> handlers = new ArrayList<>();
 
  public void addHandler(IHandler handler) {
    handlers.add(handler);
  }
  // 由责任链负责遍历所有的处理器并进行调用
  public void handle() {
    for (IHandler handler : handlers) {
      handler.handle();
    }
  }
}