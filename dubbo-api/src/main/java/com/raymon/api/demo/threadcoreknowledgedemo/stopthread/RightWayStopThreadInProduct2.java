package com.raymon.api.demo.threadcoreknowledgedemo.stopthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/7
 * @description: 生产实践中最佳实现2，在catch语句中调用Thread.currentThread().interrupt()来恢复设置中断状态
 *               以便在后续的执行中，依然能够检查到刚才发生了中断
 *               回到刚才RightWayStopThreadInProduct补上中断，让它跳出
 *               此方式为传递中断2，恢复中断
 */
public class RightWayStopThreadInProduct2 implements Runnable{
    @Override
    public void run() {
        while (true){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted, program is over");
                break;
            }
            reInterrupt();
        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            /**
             * important
             */
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProduct2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
