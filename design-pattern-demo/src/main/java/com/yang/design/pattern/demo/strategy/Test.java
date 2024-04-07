package com.yang.design.pattern.demo.strategy;

/**
 * @author yangliangchuang 2022/4/11 9:47
 */
public class Test {

    public static void main(String[] args) {

        Integer integer = new ResultHandle().handleStrategyContext("1");
        System.out.println(integer);

    }
}
