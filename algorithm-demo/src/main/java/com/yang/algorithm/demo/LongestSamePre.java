package com.yang.algorithm.demo;

import java.util.Arrays;

/**
 * @author admin 2022/3/19
 * 最长公共前缀:
 * (1)因为是公共前缀，所以这里只需要计算前两个字符串即可；
 * (2)为什么要排序：可能是想减少排序计算量;
 */
public class LongestSamePre {

    public static String replaceSpace(String[] strs) {

        // 如果检查值不合法及就返回空串
        if (!chechStrs(strs)) {
            return "";
        }
        // 数组长度
        int len = strs.length;
        // 用于保存结果
        StringBuilder res = new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else
                break;

        }
        return res.toString();

    }

    private static boolean chechStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            // 遍历strs检查元素值
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    // 测试
    public static void main(String[] args) {
        String[] strs = {"customer", "car", "cat"};
        // String[] strs = { "customer", "car", null };//空串
        // String[] strs = {};//空串
        // String[] strs = null;//空串
        System.out.println(LongestSamePre.replaceSpace(strs));// c
    }
}
