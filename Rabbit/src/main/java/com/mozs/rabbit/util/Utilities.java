package com.mozs.rabbit.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;

/**
 * Created by zhangshuai on 2016/3/11.
 */
@Slf4j
public class Utilities {

    /**
     * parse command line args
     * @param args
     * @return
     * @throws ParseException
     */
    public static CommandLine parseCommandLine(String[] args) throws ParseException {
        return new DefaultParser().parse(CommandLineUtilites.OPTS, args);
    }

    /**
     * print help info
     * @param app
     */
    public static void printCommandLineHelp(String app) {
        new HelpFormatter().printHelp(app, CommandLineUtilites.OPTS);
    }


    private static class CommandLineUtilites{
        static final Options OPTS;

        static{
            final Options opts = new Options();

            opts.addOption(new Option(Constants.CLI_HELP, "print help"));

            OPTS = opts;
        }
    }
}
