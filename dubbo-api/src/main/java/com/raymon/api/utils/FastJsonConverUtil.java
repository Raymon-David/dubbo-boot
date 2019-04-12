package com.raymon.api.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.raymon.api.pojo.order.OrderPojo;

/**
 * Author: raymon
 * Date: 2019/4/12
 * Description:fastjson工具类
 */
public class FastJsonConverUtil {

    public static OrderPojo convertJSONToObject(String message, Object obj){
        OrderPojo order = JSON.parseObject(message, new TypeReference<OrderPojo>() {});
        return order;
    }

    public static String convertObjectToJSON(Object obj){
        String text = JSON.toJSONString(obj);
        return text;
    }
}
