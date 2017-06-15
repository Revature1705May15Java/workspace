package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

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
            if (conn != null && conn.isClosed()) {
                build = false;
            }

            if (build) {
                cf = new ConnectionFactory();

                prop = new Properties();
                prop.load(new FileReader("/database.properties"));

                url = prop.getProperty("url");
                usr = prop.getProperty("usr");
                pwd = prop.getProperty("pwd");

                Class.forName(prop.getProperty("driver"));

                conn = DriverManager.getConnection(url, usr, pwd);
            }
        } catch (Exception e) {
            System.out.println("Failed to create connection factory");
        }

        return cf;
    }

    public Connection getConnection() throws InterruptedException, IOException {
        return conn;

    }

}

