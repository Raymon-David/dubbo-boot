package com.raymon.api.demo.threadcoreknowledgedemo.stopthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/7
 * @description: 如果在执行过程中，每次循环都会sleep或wait等方法，那么不需要每次迭代都检查是否已中断
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000){
                    if (num % 100 == 0){
                        System.out.println(num + "是100的倍数");
                    }
                    num++;

                        Thread.sleep(10);
                    }
                }catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
