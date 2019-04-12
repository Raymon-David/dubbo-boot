package com.raymon.provider.config.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Author: raymon
 * Date: 2019/4/12
 * Description:rabbitmq所需的定时任务，每隔一段时间拉取没有发送成功的消息，重新发送
 */
@Configuration
@EnableScheduling
public class TaskSchedulerConfig implements SchedulingConfigurer{
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(taskScheduler());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskScheduler(){
        return Executors.newScheduledThreadPool(100);
    }
}
