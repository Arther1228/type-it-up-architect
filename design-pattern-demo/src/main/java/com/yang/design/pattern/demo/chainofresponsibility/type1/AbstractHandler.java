package com.yang.design.pattern.demo.chainofresponsibility.type1;

/**
 * https://mp.weixin.qq.com/s/IvPEvf1Jn3Xejh8TbH0Inw
 */
public abstract class AbstractHandler implements Handler {
  protected Handler next = null;

  // 绑定处理器
  public void setSuccessor(Handler next) {
    this.next = next;
  }
   
  // 处理器执行操作并驱动下一个处理器
  public abstract void handle();
}