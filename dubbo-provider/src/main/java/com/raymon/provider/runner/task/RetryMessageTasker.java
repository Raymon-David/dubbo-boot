package com.raymon.provider.runner.task;

import com.raymon.api.constant.Constants;
import com.raymon.api.pojo.order.BrokerMessageLogPojo;
import com.raymon.api.pojo.order.OrderPojo;
import com.raymon.api.service.order.OrderSenderService;
import com.raymon.api.utils.FastJsonConverUtil;
import com.raymon.provider.dao.order.BrokerMessageLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Author: raymon
 * Date: 2019/4/12
 * Description:重发消息的定时任务
 */
@Component
public class RetryMessageTasker {

    private static final Logger log = LoggerFactory.getLogger(RetryMessageTasker.class);

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Autowired
    private OrderSenderService orderSenderService;

    @Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void reSend(){
        System.out.println("------定时任务开始------");
        log.info("rabbitmq 定时任务 重新发送order start");
        //pull status = 0 and timeout message
        List<BrokerMessageLogPojo> list = brokerMessageLogMapper.query4StatusAndTimeoutMessage();
        list.forEach(messageLog -> {
            if(messageLog.getTryCount() >= 3){
                //update fail message
                brokerMessageLogMapper.changeBrokerMessageLogStatus(messageLog.getMessageId(), Constants.ORDER_SEND_FAILURE, new Date());
            }else {
                //resend
                brokerMessageLogMapper.update4ReSend(messageLog.getMessageId(), new Date());
                OrderPojo reSendOrder = FastJsonConverUtil.convertJSONToObject(messageLog.getMessage(), OrderPojo.class);
                try{
                    orderSenderService.rabbitOrderSender(reSendOrder);
                }catch (Exception e){
                    log.error("定时任务异常", e);
                    e.printStackTrace();
                    System.out.println("----定时任务异常处理----");
                }
            }
        });
        log.info("rabbitmq 定时任务 重新发送order end");
    }
}
