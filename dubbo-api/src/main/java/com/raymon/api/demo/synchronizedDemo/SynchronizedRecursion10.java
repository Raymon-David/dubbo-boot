package com.raymon.api.demo.synchronizedDemo;

/**
 * Author: raymon
 * Date: 2019/4/7
 * Description:可重入粒度测试，递归调用本方法
 */
public class SynchronizedRecursion10 {

    int i = 0;

    public static void main(String[] args) {
        SynchronizedRecursion10 synchronizedRecursion = new SynchronizedRecursion10();
        synchronizedRecursion.method1();
    }

    private synchronized void method1() {
        System.out.println("This is method1 , i = " + i);
        if(i == 0){
            i++;
            method1();
        }
    }
}
