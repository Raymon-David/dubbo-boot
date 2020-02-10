package com.raymon.api.demo.threadcoreknowledgedemo.stopthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/7
 * @description: 正确的停止线程的方法，run方法内没有sleep方法或wait方法
 * @modified By：
 */
public class RightWayStopThreadWithoutSleep implements Runnable{

    /**
     * 计算数字是否为10000的倍数
     */
    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2){
            if(num % 10000 == 0){
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务结束了");
    }

    /**
     * interrupt是通知线程要中断，但不能直接中断，类似关机的时候会处理一些事情才能正常关机
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep() );
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
