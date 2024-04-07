package com.yang.regular.demo;

import org.junit.Test;

/**
 * @author yangliangchuang 2023/6/9 11:26
 */
public class SepicalCharacterTest {

    /**
     * 请注意，在正则表达式中，竖线字符 "|" 是一个特殊字符，表示“或”操作符。因此要使用双斜杠 "\" 来转义它，确保它被认为是普通字符而不是正则表达式语法中的操作符。
     */
    @Test
    public void test() {
        String str = "{\n" +
                "\"fieldIndex\":13,\n" +
                "\"filterValue\":1\n" +
                "}\n" +
                "|{\n" +
                "        \"fieldIndex\":3,\n" +
                "        \"startIndex\":0,\n" +
                "\t\"length\":2\n" +
                "}";
        String[] strArr = str.split("\\|");
        System.out.println(strArr.length);
    }
}
