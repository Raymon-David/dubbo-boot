package com.raymon.api.demo.leetcodedemo;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/19 9:31
 * @description：编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * @modified By：
 * @version: 1.0$
 */
public class ReverseString {
    public static void reverseString(char[] s) {

        String[] w = new String[s.length];
        for (int i = 0; i < s.length; i++){
            w[i] = String.valueOf(s[s.length - 1 - i]);
        }
        System.out.println(w);
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
}
