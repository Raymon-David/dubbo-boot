package com.raymon.api.demo.threadcoreknowledgedemo.stopthread.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/8
 * @description: 无法真正的用volatile停止线程，part2，陷入阻塞时，volatile无法停止线程
 *               此例中，生产者生产速度很快，消费者消费很慢，所以阻塞队列满例以后，生产者会阻塞，等待消费者进一步消费
 */
public class WrongWayVolatileCantStop {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);

        Producer producer = new Producer(storage);

        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()){
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(1000);
        }
        System.out.println("消费者不需要更多的数据了");

        /**
         * 一旦消费者不需要更多的数据了，我们应该让生产者也停下来
         * 但实际情况是生产者并没有停止
         */
        producer.canceled = true;
        System.out.println(producer.canceled);
    }
}

class Producer implements Runnable{

    volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled){
                if (num % 100 == 0){
                    storage.put(num);
                    System.out.println(num + "是100的倍数,被放到仓库中");
                }
                num++;
                Thread.sleep(1);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产者结束运行");
        }
    }
}

class Consumer{
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.95){
            return false;
        }
        return true;
    }
}