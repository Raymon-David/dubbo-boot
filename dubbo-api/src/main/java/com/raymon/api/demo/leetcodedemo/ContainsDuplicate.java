package com.raymon.api.demo.leetcodedemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/12 10:56
 * @description：给定一个整数数组，判断是否存在重复元素。
 * @modified By：
 * @version: 1.0$
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        int i =  nums.length;
        Integer[] num = IntStream.of(nums).boxed().collect(Collectors.toList()).toArray(new Integer[0]);
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(num));
        int j = set.size();
        System.out.println(set);

        if(i != j){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }
}
