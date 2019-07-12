package com.raymon.api.leetcodeDemo;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/8 14:32
 * @description：买卖股票的最佳时机
 * @modified By：
 * @version: 1.0$
 */
public class SellStockSolution {
    public static int maxProfit(int[] prices) {
        int sum=0;
        int profit;

        for (int i=0;i<prices.length-1;i++) {
            if(prices[i]<prices[i+1]&&i < prices.length-1){
                profit=prices[i+1]-prices[i];
                sum+=profit;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int w = maxProfit(prices);
        System.out.println(w);
    }
}
