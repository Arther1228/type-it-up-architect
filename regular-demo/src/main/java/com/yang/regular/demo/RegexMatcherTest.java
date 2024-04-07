package com.yang.regular.demo;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangliangchuang 2022/6/29 14:26
 */
public class RegexMatcherTest {

    public static String vehicle_num = "[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领]";

    @Test
    public void test1() {

        String plate_nbr = "蓝粤R71129";

        Pattern p = Pattern.compile(vehicle_num);
        Matcher m = p.matcher(plate_nbr);

        if (m.find()) {
            System.out.println(m.start());
            System.out.println(m.end());
        }

    }

    @Test
    public void test2() {
        String content = "I am noob " + "from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);

    }

}
