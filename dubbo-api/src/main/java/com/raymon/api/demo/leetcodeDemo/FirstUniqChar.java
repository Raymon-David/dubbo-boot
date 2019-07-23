package com.raymon.api.demo.leetcodeDemo;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/22 13:28
 * @description：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @modified By：
 * @version: 1.0$
 */
public class FirstUniqChar {
    public static int firstUniqChar(String str){

        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++){
            freq[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str.length(); i++){
            if (freq[str.charAt(i) - 'a'] == 1){
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        firstUniqChar(str);
    }
}
