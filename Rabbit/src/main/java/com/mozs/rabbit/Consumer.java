package com.mozs.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangshuai on 2016/3/11.
 */
public class Consumer {

    private final static String QUENE = "test.brick.zs";

    public static void main (String[] args) throws Exception {
        Connection connection = MQConnectionFactory.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare();
        System.out.println("## Waiting for MQ message. To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUENE, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println("## [" + getCurrentTime() + "] Received MQ message: " + msg);
        }
    }

    private static String getCurrentTime() {
        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
}
