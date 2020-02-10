package com.raymon.api.demo.threadcoreknowledgedemo.startthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/7
 * @description: 对比start和run两种启动线程的方式
 * @modified By：
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();//result is main

        /**
         * result is Thread-0
         * start方法可以启动新线程
         * start的顺序不能代表线程的执行顺序
         * start只是高速jvm合适的时候来启动
         *
         */
        new Thread(runnable).start();
    }
}
