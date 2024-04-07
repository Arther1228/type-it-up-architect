package com.yang.design.pattern.demo.singleton;

/**
 * @author yangliangchuang 2022/4/11 10:36
 * https://www.runoob.com/design-pattern/singleton-pattern.html
 */
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}