package com.raymon.consumer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 * 多线程实现0-100计数
 */
public class ThreadCount {

    public static List<Future> futureList=new ArrayList<Future>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int sum=0;
        ThreadCount add = new ThreadCount();
        ExecutorService pool= Executors.newFixedThreadPool(4);

        for(int i = 1; i <= 76;){
            ThreadTest thread = add.new ThreadTest(i,i+24);
            Future<Integer> future=pool.submit(thread);
            futureList.add(future);
            i += 25;
        }

        if(futureList!=null && futureList.size()>0){
           for(Future<Integer> future:futureList){
                sum += (Integer)future.get();
           }
        }
        System.out.println("total result: "+sum);
        pool.shutdown();
    }

    class ThreadTest implements Callable<Integer> {
        private int begin;
        private int end;
        private int sum=0;

        public ThreadTest(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            for(int i = begin; i <= end; i++){
                sum += i;
             }
            System.out.println("from "+Thread.currentThread().getName()+" sum="+sum);
            return sum;
        }
    }

}
