package com.yang.groovy.demo;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

/**
 * java调用Groovy脚本
 * https://blog.csdn.net/chengbinbbs/article/details/86743205
 */
public class GroovyClassLoaderTest {

    private final static String testScript = "def cal(int a, int b){\n" +
            "    return a+b\n" +
            "}";

    public static void main(String[] args) {
        GroovyClassLoader classLoader = new GroovyClassLoader();
        Class groovyClass = classLoader.parseClass(testScript);
        try {
            Object[] param = {8, 7};
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
            int result = (int) groovyObject.invokeMethod("cal", param);
            System.out.println(result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
