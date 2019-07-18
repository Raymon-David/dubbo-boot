package com.raymon.api.demo.synchronizedDemo;

/**
 * Author: raymon
 * Date: 2019/4/8
 * Description:类锁的第一种形式，用static修饰方法
 */
public class SynchronizedClassStatic4 implements Runnable{
    static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
    static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

    @Override
    public void run() {
        method();
    }

    public static synchronized void method(){
        System.out.println("这是类锁的第一种形式，static，名字是：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()){

        }
        System.out.println("finished");
    }
}
