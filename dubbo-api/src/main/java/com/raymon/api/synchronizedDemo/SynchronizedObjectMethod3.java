package com.raymon.api.synchronizedDemo;

/**
 * Author: raymon
 * Date: 2019/4/8
 * Description:对象锁，示例2，方法锁形式
 */
public class SynchronizedObjectMethod3 implements Runnable{
    static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();
    @Override
    public void run() {
        method();
    }

    /**
     * 把方法抽象成普通方法来调用
     */
    public synchronized void method(){
        System.out.println("我是对象锁的方法修饰附形式，我是：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()){

        }
        System.out.println("finished");
    }
}
