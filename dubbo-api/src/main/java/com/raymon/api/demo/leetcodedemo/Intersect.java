package com.raymon.api.demo.leetcodedemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/12 11:23
 * @description：给定两个数组，编写一个函数来计算它们的交集。
 * @modified By：
 * @version: 1.0$
 */
public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {

        List list = new ArrayList();
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                if (nums1[i] == nums2[j]){
                    System.out.println(i);
                    list.add(nums1[i]);
                    break;
                }
            }
        }

        System.out.println(list);
        int[] o = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            o[i] = (int)list.get(i);
        }

        return o;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        intersect(nums1, nums2);

    }
}
