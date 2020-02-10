package com.raymon.api.demo.threadcoreknowledgedemo.stopthread.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/8
 * @description: 用中断来修复刚才无尽等待的问题
 */
public class WrongWayVolatileFixed {

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatileFixed wrongWayVolatileFixed = new WrongWayVolatileFixed();

        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);

        Provider provider = wrongWayVolatileFixed.new Provider(storage);

        Thread providerThread = new Thread(provider);
        providerThread.start();
        Thread.sleep(1000);

        Customer customer = wrongWayVolatileFixed.new Customer(storage);
        while (customer.needMoreNums()){
            System.out.println(customer.storage.take() + "被消费了");
            Thread.sleep(1000);
        }
        System.out.println("消费者不需要更多的数据了");

        /**
         * 用interrupt让生产者停止
         */
        providerThread.interrupt();
        System.out.println(provider.canceled);
    }

    class Provider implements Runnable{

        volatile boolean canceled = false;
        BlockingQueue storage;

        public Provider(BlockingQueue storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 100000 && !Thread.currentThread().isInterrupted()){
                    if (num % 100 == 0){
                        storage.put(num);
                        System.out.println(num + "是100的倍数,被放到仓库中");
                    }
                    num++;
                    Thread.sleep(1);
                }
            }catch (InterruptedException e) {
                //可以写其他停止的逻辑
                e.printStackTrace();
            }finally {
                System.out.println("生产者结束运行");
            }
        }
    }

    class Customer{
        BlockingQueue storage;

        public Customer(BlockingQueue storage) {
            this.storage = storage;
        }

        public boolean needMoreNums() {
            if (Math.random() > 0.95){
                return false;
            }
            return true;
        }
    }

}



