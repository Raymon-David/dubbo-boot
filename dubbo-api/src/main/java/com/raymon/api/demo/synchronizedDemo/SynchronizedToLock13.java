package com.raymon.api.demo.synchronizedDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: raymon
 * Date: 2019/4/7
 * Description:synchronized和lock等价的类
 */
public class SynchronizedToLock13 {

    public synchronized void method1(){
        System.out.println("This is synchronized");
    }

    public void method2(){
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            System.out.println("This is lock");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock13 synchronizedToLock = new SynchronizedToLock13();
        synchronizedToLock.method1();
        synchronizedToLock.method2();
    }
}
