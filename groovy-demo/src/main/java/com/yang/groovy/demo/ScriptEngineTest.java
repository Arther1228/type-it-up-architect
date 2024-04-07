package com.yang.groovy.demo;

import org.codehaus.groovy.jsr223.GroovyScriptEngineFactory;

import javax.script.Invocable;
import javax.script.ScriptEngine;

public class ScriptEngineTest {

    private static final GroovyScriptEngineFactory scriptEngineFactory = new GroovyScriptEngineFactory();

    private final static String testScript = "def cal(int a, int b){\n" +
            "    return a+b\n" +
            "}";

    private static <T> T invoke(String script, String function, Object... objects) throws Exception {
        ScriptEngine scriptEngine = scriptEngineFactory.getScriptEngine();
        scriptEngine.eval(script);
        return (T) ((Invocable) scriptEngine).invokeFunction(function, objects);
    }

    public static void main(String[] args) throws Exception {
        Object cal = invoke(testScript, "cal", 8, 7);
        System.out.println(cal);
    }
}
