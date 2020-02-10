package com.raymon.api.demo.threadcoreknowledgedemo.stopthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/7
 * @description: 生产实践中最佳实现，catch住InterruptedException之后优先选择：在方法签名中抛出这个异常
 *               那么run（）就会强制try/catch
 *               此方式为传递中断
 */
public class RightWayStopThreadInProduct implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                //可以保存日志或者停止程序
                System.out.println("stop this program");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProduct());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
