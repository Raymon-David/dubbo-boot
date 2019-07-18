package com.raymon.api.demo.synchronizedDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: raymon
 * Date: 2019/4/7
 * Description:展示lock的方法
 */
public class LockExample15 {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.tryLock();
        lock.tryLock(30, TimeUnit.SECONDS);
    }
}
