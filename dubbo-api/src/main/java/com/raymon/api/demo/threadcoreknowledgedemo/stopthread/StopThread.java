package com.raymon.api.demo.threadcoreknowledgedemo.stopthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/8
 * @description: 这是一种错误的停止线程的方法，用stop停止线程，会导致线程运行一半，突然停止，
 *               没办法完成一个基本单位的操作（一个连队），会造成藏数据（有的连队多领取或少领取装备）
 */
public class StopThread implements Runnable{
    @Override
    public void run() {
        //模拟指挥军队，一共有5个连队，每个连队10人，以连队为单位，发放装备，叫到号到士兵前去领取
        for (int i = 0; i < 5; i++){
            System.out.println("连队 " + i + " 开始领取装备");
            for (int j = 0; j < 10; j++){
                System.out.println(j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队 " + i + " 已经领取完装备");

        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
