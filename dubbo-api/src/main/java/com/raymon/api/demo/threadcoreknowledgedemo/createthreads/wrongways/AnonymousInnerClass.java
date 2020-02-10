package com.raymon.api.demo.threadcoreknowledgedemo.createthreads.wrongways;

/**
 * @author ：raymon
 * @date ：Created in 2020/1/6 10:56 下午
 * @description：用匿名内部类实现线程
 * @modified By：
 * @version: 1.0$
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
