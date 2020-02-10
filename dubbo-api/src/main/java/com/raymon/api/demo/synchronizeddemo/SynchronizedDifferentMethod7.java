package com.raymon.api.demo.synchronizeddemo;

/**
 * Author: raymon
 * Date: 2019/3/31
 * Description:同时访问同一个类中的不同的同步方法
 */
public class SynchronizedDifferentMethod7 implements Runnable{

    static SynchronizedDifferentMethod7 instance = new SynchronizedDifferentMethod7();

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

    public synchronized void method1(){
        System.out.println("这是第method1，是加锁的" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }

    public synchronized void method2(){
        System.out.println("这是第method2，是加锁的" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }
}
