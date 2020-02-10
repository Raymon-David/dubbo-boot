package com.raymon.api.demo.threadcoreknowledgedemo.createthreads;

/**
 * @author ：raymon
 * @date ：Created in 2020/1/6 10:22 下午
 * @description：用Thread方式实现线程
 * @modified By：
 * @version: 1.0$
 */
public class ThreadStyle extends Thread {
    @Override
    public void run(){
        System.out.println("用Thread方式实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
