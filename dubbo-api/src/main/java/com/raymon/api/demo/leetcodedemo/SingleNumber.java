package com.raymon.api.demo.leetcodedemo;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/12 11:06
 * @description：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @modified By：
 * @version: 1.0$
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {

        int u = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = 0; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    sum ++;
                }
            }
            if (sum < 2){
                u = nums[i];
            }

        }
        return u;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        int w = singleNumber(nums);
        System.out.println(w);
    }
}
