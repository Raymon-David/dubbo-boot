package com.raymon.api.demo.synchronizeddemo;

/**
 * Author: raymon
 * Date: 2019/4/10
 * Description:同时访问静态同步方法和非静态同步方法
 */
public class SynchronizedStaticAndNormal8 implements Runnable{
    static SynchronizedStaticAndNormal8 instance = new SynchronizedStaticAndNormal8();
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else{
            method2();
        }
    }

    public static void main(String[] args){
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();
        thread2.start();

        while(thread1.isAlive() || thread2.isAlive()){
        }
        System.out.println("执行完毕");
    }

    public synchronized static void method1(){
        System.out.println("这是第method1，是静态加锁的" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }

    public synchronized void method2(){
        System.out.println("这是第method2，是非静态加锁的" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }
}
