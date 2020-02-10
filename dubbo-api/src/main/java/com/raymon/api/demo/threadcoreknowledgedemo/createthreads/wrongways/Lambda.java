package com.raymon.api.demo.threadcoreknowledgedemo.createthreads.wrongways;

/**
 * @author ：raymon
 * @date ：Created in 2020/1/6 10:59 下午
 * @description：用Lambda表达式创建线程
 * @modified By：
 * @version: 1.0$
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
