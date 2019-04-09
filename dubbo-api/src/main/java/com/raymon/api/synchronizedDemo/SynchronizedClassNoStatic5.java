package com.raymon.api.synchronizedDemo;

/**
 * Author: raymon
 * Date: 2019/4/8
 * Description:类锁的第二种形式，*.class形式
 */
public class SynchronizedClassNoStatic5 implements Runnable{
    static SynchronizedClassNoStatic5 instance1 = new SynchronizedClassNoStatic5();
    static SynchronizedClassNoStatic5 instance2 = new SynchronizedClassNoStatic5();

    @Override
    public void run() {
        synchronized (SynchronizedClassNoStatic5.class){
            System.out.println("这是类锁的第二种形式，synchronized（*.class），我是：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
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
