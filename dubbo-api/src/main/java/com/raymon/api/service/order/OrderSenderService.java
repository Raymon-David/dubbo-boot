package com.raymon.api.service.order;

import com.raymon.api.pojo.order.OrderPojo;

/**
 * Author: raymon
 * Date: 2019/4/11
 * Description:
 */
public interface OrderSenderService {

    void orderSender(OrderPojo order);

    void rabbitOrderSender(OrderPojo orderPojo);

    void createOrder(OrderPojo order);
}
