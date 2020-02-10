package com.raymon.api.demo.threadcoreknowledgedemo.stopthread;

/**
 * @author ：Raymon
 * @date ：Created in 2020/1/7
 * @description: run方法无法再往外层抛出异常，只能用try/catch
 */
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
