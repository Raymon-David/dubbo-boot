package com.raymon.api.demo.synchronizeddemo;

/**
 * Author: raymon
 * Date: 2019/4/8
 * Description:消失的请求
 */
public class DisappearRequest1 implements Runnable{

    static DisappearRequest1 instance = new DisappearRequest1();
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();//启动线程
        thread2.start();
        thread1.join();//thread1执行之后再执行thread2
        thread2.join();
        System.out.println(i);
    }

    /**
     * 类锁，*.class
     */
    public void method1(){
        synchronized (DisappearRequest1.class){
            for(int j = 0; j < 100000; j++){
                i++;
            }
        }
    }

    /**
     * 类锁，synchronized修饰static方法
     */
    public synchronized static void method2(){
        for(int j = 0; j < 100000; j++){
            i++;
        }
    }

    /**
     * 对象锁，用synchronized修饰普通方法
     */
    public synchronized void method3(){
        for(int j = 0; j < 100000; j++){
            i++;
        }
    }

    /**
     * 对象锁，用synchronized修饰this
     */
    public void method4(){
        synchronized (this){
            for(int j = 0; j < 100000; j++){
                i++;
            }
        }
    }

    @Override
    public void run() {
        method2();
    }
}
