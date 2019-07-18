package com.raymon.api.demo.leetcodeDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/8 14:32
 * @description：从排序数组中删除重复项
 * @modified By：
 * @version: 1.0$
 */
class Solution {
    public static int removeDuplicates(int[] nums) {
        Integer[] num = IntStream.of(nums).boxed().collect(Collectors.toList()).toArray(new Integer[0]);
        Set<Integer> st = new HashSet<Integer>(Arrays.asList(num));
        Object[] result = st.toArray();
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
        System.out.println(result.length);
        return result.length;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,1,2};
        removeDuplicates(nums);
    }

}
