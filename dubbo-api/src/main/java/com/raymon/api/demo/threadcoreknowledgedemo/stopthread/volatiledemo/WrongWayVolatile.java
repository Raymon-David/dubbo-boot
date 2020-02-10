package com.raymon.api.demo.threadcoreknowledgedemo.stopthread.volatiledemo;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/8
 * @description: volatile的局限，part1，看似可行
 */
public class WrongWayVolatile implements Runnable{

    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled){
                if (num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(1);
                }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WrongWayVolatile wrongWayVolatile = new WrongWayVolatile();
        Thread thread = new Thread(wrongWayVolatile);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wrongWayVolatile.canceled = true;
    }
}
