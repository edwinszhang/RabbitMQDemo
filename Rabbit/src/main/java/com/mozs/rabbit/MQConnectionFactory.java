package com.mozs.rabbit;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * Custom MQ connection factory
 * Created by zhangshuai on 2016/3/11.
 */
public class MQConnectionFactory {
    private final static String USERNAME = "scott";
    private final static String PASSWORD = "tiger";
    private final static String VIRTUAL_HOST = "/rabbit-zs";
    private final static int TIMEOUT = 10000;
    private final static int HEARTBEAT = 60;
    private final static String HOST_ADDRESS = "ldns-dt-2678";
    private final static int PORT = 5672;

    /**
     * hide construction method
     */
    private MQConnectionFactory (){}

    /**
     * get a connection of rabbit mq
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername(USERNAME);
        connectionFactory.setPassword(PASSWORD);
        connectionFactory.setVirtualHost(VIRTUAL_HOST);
        connectionFactory.setConnectionTimeout(TIMEOUT);
        connectionFactory.setRequestedHeartbeat(HEARTBEAT);
        connectionFactory.setHost(HOST_ADDRESS);
        connectionFactory.setPort(PORT);

        return connectionFactory.newConnection();
    }
}
