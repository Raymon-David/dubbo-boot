package com.raymon.api.pojo.order;

import java.io.Serializable;

/**
 * Author: raymon
 * Date: 2019/4/11
 * Description:订单实体类
 */
public class OrderPojo implements Serializable{
    private String id;

    private String name;

    private String messageId;//发送消息的唯一标示

    public OrderPojo(){

    }

    public OrderPojo(String id, String name, String messageId){
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

}
