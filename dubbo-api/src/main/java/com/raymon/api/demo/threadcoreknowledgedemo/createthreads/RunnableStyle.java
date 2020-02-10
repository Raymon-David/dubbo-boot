package com.raymon.api.demo.threadcoreknowledgedemo.createthreads;

/**
 * @author ：raymon
 * @date ：Created in 2020/1/6 10:20 下午
 * @description：用Runnable方式创建线程
 * @modified By：
 * @version: 1.0$
 */
public class RunnableStyle implements Runnable {
    @Override
    public void run() {
        System.out.println("用Runnable方式实现线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}
