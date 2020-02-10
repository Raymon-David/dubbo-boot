package com.raymon.api.demo.threadcoreknowledgedemo.createthreads.wrongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：raymon
 * @date ：Created in 2020/1/6 10:44 下午
 * @description：使用线程池创建线程
 * @modified By：
 * @version: 1.0$
 */
public class ThreadPool5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 1000; i++){
            executorService.submit(new Task(){

            });
        }
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name is " + Thread.currentThread().getName());
        }
    }
}
