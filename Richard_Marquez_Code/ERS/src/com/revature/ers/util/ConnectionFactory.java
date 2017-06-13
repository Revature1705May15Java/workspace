package com.revature.ers.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    private static Boolean build=true;
    private static ConnectionFactory cf = null;


    private ConnectionFactory() {
        build = false;
    }

    public static synchronized ConnectionFactory getInstance() {
        if(build==true){
            cf = new ConnectionFactory();
        }

        return cf;
    }
    public Connection getConnection() throws InterruptedException {
        Connection conn = null;
//        String url = "jdbc:oracle:thin:@localhost:1521:xe";
//        String username = "ers";
//        String password = "p4ssw0rd";

        try {
            Properties prop = new Properties();
            prop.load(new FileReader("C:\\database.properties"));
//            prop.load(new FileReader("database.properties"));
            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"), prop.getProperty("pwd"));

//            Class.forName("oracle.jdbc.OracleDriver");
//            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            e.printStackTrace();
            Thread.sleep(500);
            return getConnection();
        }
        return conn;

    }





}

