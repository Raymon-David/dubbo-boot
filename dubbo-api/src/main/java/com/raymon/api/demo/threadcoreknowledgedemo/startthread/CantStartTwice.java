package com.raymon.api.demo.threadcoreknowledgedemo.startthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/7
 * @description: 演示不能两次执行start方法，否则会报错
 * @modified By：
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();

        /**
         * java.lang.IllegalThreadStateException
         */
        thread.start();
        thread.start();
    }
}
