package com.mozs.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by zhangshuai on 2016/3/11.
 */
public class Producer {

    private final static String EXCHANGE_NAME = "test.entry.zs";
    private final static String ROUTE_KEY = "brick.zs";

    public static void main (String[] args) throws  Exception{
        Connection connection = MQConnectionFactory.getConnection();
        Channel channel = connection.createChannel();
        String msg = "testing sending...";
        channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY, null, msg.getBytes());
        channel.close();
        connection.close();
    }
}
