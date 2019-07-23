package com.raymon.api.demo.leetcodeDemo;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/22 10:02
 * @description：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @modified By：
 * @version: 1.0$
 */
public class ReverseNumber {
    public static int reverse(int x){
//        int temp = Math.abs(x);
//        System.out.println(temp);
//        String str = Integer.toString(temp);
//        StringBuffer sb = new StringBuffer(str);
//        String result = sb.reverse().toString();
//
//        if (Long.parseLong(result) > Integer.MAX_VALUE){
//            result = "0";
//        }
//
//        return x > 0 ? Integer.parseInt(result) : -Integer.parseInt(result);

        long result = 0;
        int tmp = Math.abs(x);
        while (tmp > 0) {
            result *= 10;
            result += tmp % 10;
            if (result > Integer.MAX_VALUE){
                return 0;
            }
            tmp /= 10;
        }
        return (int)(x >= 0 ? result : -result);
    }

    public static void main(String[] args) {
        int x = -2147483648;
        reverse(x);
    }
}
