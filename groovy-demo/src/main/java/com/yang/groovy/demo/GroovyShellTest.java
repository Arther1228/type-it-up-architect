package com.yang.groovy.demo;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.runtime.InvokerHelper;

public class GroovyShellTest {

    private static GroovyShell groovyShell = new GroovyShell();

    private final static String testScript = "def cal(int a, int b){\n" +
            "    return a+b\n" +
            "}";

    private static <T> T invoke(String scriptText, String function, Object... objects) throws Exception {
        Script script = groovyShell.parse(scriptText);
        return (T) InvokerHelper.invokeMethod(script, function, objects);
    }


    public static void main(String[] args) throws Exception {
        Object cal = invoke(testScript, "cal", 8, 7);
        System.out.println(cal);
    }

}
