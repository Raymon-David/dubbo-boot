package com.raymon.api.demo.threadcoreknowledgedemo.createthreads.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ：raymon
 * @date ：Created in 2020/1/6 10:52 下午
 * @description：定时器创建线程
 * @modified By：
 * @version: 1.0$
 */
public class TimmerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("name is " + Thread.currentThread().getName());
            }
        }, 1000, 1000);
    }
}
