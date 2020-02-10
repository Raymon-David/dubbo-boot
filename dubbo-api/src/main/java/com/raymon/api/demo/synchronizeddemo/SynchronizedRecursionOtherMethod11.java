package com.raymon.api.demo.synchronizeddemo;

/**
 * Author: raymon
 * Date: 2019/4/7
 * Description:可重入粒度测试，调用类内另外的方法
 */
public class SynchronizedRecursionOtherMethod11 {

    public static void main(String[] args) {
        SynchronizedRecursionOtherMethod11 synchronizedRecursionOtherMethod11 = new SynchronizedRecursionOtherMethod11();
        synchronizedRecursionOtherMethod11.method1();
    }

    private synchronized void method2() {
        System.out.println("This is method2");
    }

    private synchronized void method1() {
        System.out.println("This is method1");
        method2();
    }
}
