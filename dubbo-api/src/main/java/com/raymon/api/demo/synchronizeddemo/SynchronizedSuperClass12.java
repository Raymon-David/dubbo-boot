package com.raymon.api.demo.synchronizeddemo;

/**
 * Author: raymon
 * Date: 2019/4/7
 * Description:可重入粒度测试，调用父类的方法，即调用其他类中的方法
 */
public class SynchronizedSuperClass12 {

    public synchronized void doSomthing(){
        System.out.println("This is super class");
    }
}

class TestClass extends SynchronizedSuperClass12{
    public synchronized void doSomthing(){
        System.out.println("This is son class");
        super.doSomthing();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.doSomthing();
    }
}