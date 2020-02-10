package com.raymon.api.demo.leetcodedemo;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/18 11:02
 * @description：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @modified By：
 * @version: 1.0$
 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {

        int curIndex = nums.length - 1;
        int lastIndex = nums.length - 1;
        int count = 0;

        while (curIndex >= 0) {
            if (nums[curIndex] == 0) {
                count = lastIndex - curIndex;
                for (int i = 0; i < count; i++) {
                    nums[curIndex + i] = nums[curIndex + i + 1];
                }
                nums[lastIndex] = 0;
                lastIndex--;
            }
            curIndex--;
        }

        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
}
