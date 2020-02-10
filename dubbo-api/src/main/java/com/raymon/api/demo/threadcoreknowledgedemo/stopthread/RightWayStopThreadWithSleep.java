package com.raymon.api.demo.threadcoreknowledgedemo.stopthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/7
 * @description: 带有sleep方法的中断线程的写法
 * @modified By：
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 500 && !Thread.currentThread().isInterrupted()){
                if (num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                /**
                 * java.lang.InterruptedException: sleep interrupted
                 */
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
