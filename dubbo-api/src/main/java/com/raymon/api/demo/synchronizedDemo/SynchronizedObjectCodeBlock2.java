package com.raymon.api.demo.synchronizedDemo;

/**
 * Author: raymon
 * Date: 2019/4/8
 * Description:对象锁，示例1，代码块形式
 */
public class SynchronizedObjectCodeBlock2 implements Runnable{

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();
    Object lock1 = new Object();
    Object lock2 = new Object();

    /**
     * 使用两把锁
     * lock1在thread0释放锁后，thread1才开始使用
     * lock2在thread0释放锁后，thread1才开始使用
     *
     * 由于加的是两把锁，所以这两把锁可以并行
     */
    @Override
    public void run() {
        /**
         * lock1可以用this代替，即代码块的对象锁
         */
        synchronized (lock1){
            System.out.println("我是对象锁lock1的代码块形式，我的名字是:" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock1运行结束");
        }

        synchronized (lock2){
            System.out.println("我是对象锁lock2的代码块形式，我的名字是:" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock2运行结束");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();
        thread2.start();

        while(thread1.isAlive() || thread2.isAlive()){//两个线程都要执行完毕

        }
        System.out.println("finished");
    }
}
