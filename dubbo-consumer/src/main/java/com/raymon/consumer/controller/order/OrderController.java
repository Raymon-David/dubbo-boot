package com.raymon.consumer.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rabbitmq.client.Channel;
import com.raymon.api.pojo.order.OrderPojo;
import com.raymon.api.service.order.OrderSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Author: raymon
 * Date: 2019/4/11
 * Description:发送rabbitmq消息测试
 */
@RestController
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private OrderSenderService orderSenderService;

    /**
     * 发送消息
     * 一般处理业务的同时发送消息，供其他业务消费
     */
    @RequestMapping(value ="/order/sendOrder")
    public void sendOrder(){
        log.info(" ------ OrderController sendOrder start -----");

        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setId("2019040001");
        orderPojo.setName("hello rabbitmq");
        orderPojo.setMessageId(System.currentTimeMillis() + "-" + UUID.randomUUID().toString());
        orderSenderService.createOrder(orderPojo);

        log.info(" ------ OrderController sendOrder end -----");
    }

    /**
     * 接收消息
     * RabbitListener可以实现自动装配绑定，绑定queue，exchange，key
     * durable是否持久化，一般为true
     * type有几种可选，一般选topic
     * key是routing-key，其中#表示通配符，*也是通配符，但是#比*适配的多
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "order-queue", durable = "true"),
                                            exchange = @Exchange(value = "order-exchange",durable = "true", type = "topic"),
                                            key = "order.#"
                                            )
                    )
    @RabbitHandler
    public void receiveOrder(@Payload OrderPojo orderPojo, @Headers Map<String, Object> headers, Channel channel){
        log.info(" ------ OrderController receiveOrder start -----");

        //consumer操作
        System.out.println("--------收到消息，开始消费---------");
        System.out.println("订单ID是：" + orderPojo.getId());
        log.info(" OrderController receiveOrder 订单ID是 : " + orderPojo.getId());
        /**
         * 由于是手动签收，所以要完成以下操作
         * Delivery Tag 用来标识信道中投递的消息。RabbitMQ 推送消息给 Consumer 时，会附带一个 Delivery Tag，
         * 以便 Consumer 可以在消息确认时告诉 RabbitMQ 到底是哪条消息被确认了。
         * RabbitMQ 保证在每个信道中，每条消息的 Delivery Tag 从 1 开始递增。
         */
        Long deliverTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        //ACK 消费之后把队列清空
        try {
            /**
             *  multiple 取值为 false 时，表示通知 RabbitMQ 当前消息被确认
             *  如果为 true，则额外将比第一个参数指定的 delivery tag 小的消息一并确认
             */
            boolean multiple = false;

            //ACK,确认一条消息已经被消费
            channel.basicAck(deliverTag, multiple);

        } catch (IOException e) {
            log.error("OrderController receiveOrder Exception: ", e);
            e.printStackTrace();
        }
        log.info(" ------ OrderController receiveOrder end -----");
    }
}
