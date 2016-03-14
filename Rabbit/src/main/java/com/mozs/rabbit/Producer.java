package com.mozs.rabbit;

import com.mozs.rabbit.util.Constants;
import com.mozs.rabbit.util.Utilities;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.utility.Utility;
import org.apache.commons.cli.CommandLine;

/**
 * Created by zhangshuai on 2016/3/11.
 */
public class Producer {

    private final static String EXCHANGE_NAME = "test.entry.zs";
    private final static String ROUTE_KEY = "brick.zs";

    public static void main (String[] args) throws  Exception{
        CommandLine commandLine = Utilities.parseCommandLine(args);
        if (commandLine.hasOption(Constants.CLI_HELP)) {
            Utilities.printCommandLineHelp(Constants.APP_NAME);
            return;
        }

//        String Message = get
        Connection connection = MQConnectionFactory.getConnection();
        Channel channel = connection.createChannel();
        String msg = "testing sending...";
        msg += args[0];
        channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY, null, msg.getBytes());
        channel.close();
        connection.close();
    }
}
