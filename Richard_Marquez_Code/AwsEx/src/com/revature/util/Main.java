package com.revature.util;

import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
//        BasicConfigurator.configure();
        DOMConfigurator.configure("log4j.xml");

        Logger.getLogger(Main.class).info("test log");
        logger.warn("test warninglog");
    }
}
