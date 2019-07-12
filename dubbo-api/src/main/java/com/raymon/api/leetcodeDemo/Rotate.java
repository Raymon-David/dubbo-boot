package com.raymon.api.leetcodeDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/12 10:25
 * @description：旋转数组
 * @modified By：
 * @version: 1.0$
 */
public class Rotate {

    public static void rotate(int[] nums, int k) {


        for(int i = 0; i < k; i++){
            int[] newNums = new int[nums.length];
            newNums[0] = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j++){
                newNums[j] = nums[j - 1];
            }
            nums = newNums;
            System.out.println(Arrays.toString(newNums));
        }


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k =3;
        rotate(nums, k);
    }
}
