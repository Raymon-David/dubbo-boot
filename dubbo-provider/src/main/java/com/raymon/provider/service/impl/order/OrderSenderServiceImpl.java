package com.raymon.provider.service.impl.order;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.api.constant.Constants;
import com.raymon.api.pojo.order.BrokerMessageLogPojo;
import com.raymon.api.pojo.order.OrderPojo;
import com.raymon.api.service.order.OrderSenderService;
import com.raymon.api.utils.DateUtil;
import com.raymon.api.utils.FastJsonConverUtil;
import com.raymon.provider.dao.order.BrokerMessageLogMapper;
import com.raymon.provider.dao.order.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Author: raymon
 * Date: 2019/4/11
 * Description:rabbitmq发送order
 */
@Service(version = "${dubbo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class OrderSenderServiceImpl implements OrderSenderService{

    private static final Logger log = LoggerFactory.getLogger(OrderSenderServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void orderSender(OrderPojo order) {
        log.info(" ------ OrderSenderServiceImpl orderSender start -----");

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());

        log.info(" OrderSenderServiceImpl orderSender start , order-exchange, order.001, {}, {} " + order, correlationData);

        rabbitTemplate.convertAndSend("order-exchange", //交换机exchange
                "order.001",//routingkey
                order,//消息实体类
                correlationData);//消息唯一id

        log.info(" ------ OrderSenderServiceImpl orderSender end -----");
    }

    /**
     * 创建订单
     * @param order
     */
    @Override
    public void createOrder(OrderPojo order) {
        // 使用当前时间当做订单创建时间（为了模拟一下简化）
        Date orderTime = new Date();
        // 插入业务数据
        orderMapper.insert(order);
        // 插入消息记录表数据
        BrokerMessageLogPojo brokerMessageLog = new BrokerMessageLogPojo();
        // 消息唯一ID
        brokerMessageLog.setMessageId(order.getMessageId());
        // 保存消息整体 转为JSON 格式存储入库
        brokerMessageLog.setMessage(FastJsonConverUtil.convertObjectToJSON(order));
        // 设置消息状态为0 表示发送中
        brokerMessageLog.setStatus("0");
        // 设置消息未确认超时时间窗口为 一分钟
        brokerMessageLog.setNextRetry(DateUtil.addMinutes(orderTime, Constants.ORDER_TIMEOUT));
        brokerMessageLog.setCreateTime(new Date());
        brokerMessageLog.setUpdateTime(new Date());
        brokerMessageLogMapper.insertSelective(brokerMessageLog);
        // 发送消息
        rabbitOrderSender(order);
    }

    /**
     * 发送消息调用，构建自定义对象消息
     * @param orderPojo
     */
    @Override
    public void rabbitOrderSender(OrderPojo orderPojo) {
        log.info(" ------ OrderSenderServiceImpl RabbitOrderSender start -----");

        //通过实现canfirmcallback接口，消息发送到broker后触发回调，确认消息是否送达broker，也就是只确认是否正确送达exchaneg中
        rabbitTemplate.setConfirmCallback(confirmCallback);
        //消息唯一id
        CorrelationData correlationData = new CorrelationData(orderPojo.getMessageId());

        log.info(" OrderSenderServiceImpl orderSender start , order-exchange, order.002, {}, {} " + orderPojo, correlationData);

        rabbitTemplate.convertAndSend("order-exchange", "order.002", orderPojo, correlationData);

        log.info(" ------ OrderSenderServiceImpl RabbitOrderSender end -----");
    }

    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.out.println("correlationData is : " + correlationData);
            String messageId = correlationData.getId();

            if(ack){
                //如果confirm返回成功，则更新状态
                brokerMessageLogMapper.changeBrokerMessageLogStatus(messageId, Constants.ORDER_SEND_SUCCESS, new Date());
            }else{
                //失败则进行后续的操作：重试， 或者补偿等手段
                System.out.println("异常处理中。。。");
            }
        }
    };
}
