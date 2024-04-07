package com.yang.regular.demo;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangliangchuang 2023/2/6 14:42
 *
 * 车牌正则
 *
 * https://blog.csdn.net/xuaner8786/article/details/108239686
 */
public class PlateNoTest {

    private static String patten_1 = "/^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/";

    private static String patten_2 = "/^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[a-zA-Z](([DF]((?![IO])[a-zA-Z0-9](?![IO]))[0-9]{4})|([0-9]{5}[DF]))|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1})$/";


    /**
     * 排除车牌中的乱码，并不是真正的真假车牌识别正则
     */
    @Test
    public void test3(){

        String plateNo = "皖DL168R�";
        String strPatten = "[A-Z0-9\\u4E00-\\u9FFF]+";
        Pattern pattern = Pattern.compile(strPatten);
        Matcher m = pattern.matcher(plateNo);
        if (m.find()) {
            plateNo = m.group(0);
            System.out.println(plateNo);
        }

    }

}
