package com.yang.algorithm.demo;

/**
 * @author admin 2022/3/19
 */
//https://www.weiweiblog.cn/replacespace/

public class ReplaceSpace {

    /**
     * 第一种方法：常规方法。利用String.charAt(i)以及String.valueOf(char).equals(" "
     * )遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
     */
    public static String replaceSpace(StringBuffer str) {

        int length = str.length();
        // System.out.println("length=" + length);
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char b = str.charAt(i);
            if (String.valueOf(b).equals(" ")) {
                result.append("%20");
            } else {
                result.append(b);
            }
        }
        return result.toString();

    }

    /**
     * 第二种方法：利用API替换掉所用空格，一行代码解决问题
     */
    public static String replaceSpace2(StringBuffer str) {

        return str.toString().replaceAll("\\s", "%20");
    }

    /**
     * 对于替换固定字符（比如空格）的情况，第二种方法其实可以使用 replace 方法替换，性能更好!
     */
    public static String replaceSpace3(StringBuffer str) {

        return str.toString().replace(" ", "%20");
    }


}
