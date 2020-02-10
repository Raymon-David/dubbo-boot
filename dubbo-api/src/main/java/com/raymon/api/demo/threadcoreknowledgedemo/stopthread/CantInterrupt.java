package com.raymon.api.demo.threadcoreknowledgedemo.stopthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/7
 * @description: 如果while里面放try catch，会导致中断失效
 */
public class CantInterrupt {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 1000000){
                if(num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    /**
                     * 这种情况下，sleep之后把interrupt的标志位删除，所以会继续执行
                     */
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
