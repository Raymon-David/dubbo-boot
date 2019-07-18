package com.raymon.api.demo.leetcodeDemo;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/12 13:57
 * @description：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * @modified By：
 * @version: 1.0$
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {

        int over = 1;
        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] + over > 9) {
                digits[i] = 0;
                over = 1;
            } else {
                digits[i] = digits[i] + over;
                over = 0;
            }
        }
        int[] res;
        if (over == 1) {
            res = new int[digits.length + 1];
            res[0] = over;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
        } else {
            res = digits;
        }

        for (int j = 0; j < res.length; j++){
            System.out.println(res[j]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        plusOne(digits);
    }
}
