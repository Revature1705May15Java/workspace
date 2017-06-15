package com.revature.ers.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.*;
import org.apache.log4j.xml.*;

public class ConnectionFactory {

    static {
        DOMConfigurator.configure("log4j.xml");
    }

    private static Boolean build=true;
    private static ConnectionFactory cf = null;
    private static Properties prop;
    private static String url;
    private static String usr;
    private static String pwd;
    private static Connection conn;


    private ConnectionFactory() {
        build = false;
    }

    public static synchronized ConnectionFactory getInstance() {
        try {
            if (build) {
                cf = new ConnectionFactory();

                prop = new Properties();
                prop.load(new FileReader("/database.properties"));

                url = prop.getProperty("url");
                usr = prop.getProperty("usr");
                pwd = prop.getProperty("pwd");

                Class.forName(prop.getProperty("driver"));
            }
        } catch (Exception e) {
            Logger.getLogger(ConnectionFactory.class).error("Failed to get instance");
        }

        return cf;
    }

    public Connection getConnection() throws InterruptedException, IOException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, usr, pwd);
            }
        } catch (Exception e) {
            Logger.getLogger(ConnectionFactory.class).error("Failed to get connection");
            Thread.sleep(500);
            return getConnection();
        }

        return conn;

    }

}

