package com.yang.algorithm.demo;

import java.util.HashSet;

/**
 * @author admin 2022/3/19
 */
public class LongestPalindromeLength {

    public int longestPalindrome(String s) {
        if (s.length() == 0)
            return 0;
        // 用于存放字符
        HashSet<Character> hashset = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashset.contains(chars[i])) {// 如果hashset没有该字符就保存进去
                hashset.add(chars[i]);
            } else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
                hashset.remove(chars[i]);
                count++;
            }
        }
        return hashset.isEmpty() ? count * 2 : count * 2 + 1;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(new LongestPalindromeLength().longestPalindrome(str));
    }
}
