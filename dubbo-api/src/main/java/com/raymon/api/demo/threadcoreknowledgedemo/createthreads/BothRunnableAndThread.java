package com.raymon.api.demo.threadcoreknowledgedemo.createthreads;

/**
 * @author ：raymon
 * @date ：Created in 2020/1/6 10:34 下午
 * @description：同时使用Runnable和Thread来实现线程
 * @modified By：
 * @version: 1.0$
 */
public class BothRunnableAndThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am from Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("I am from Thread");
            }
        }.start();

    }
}
