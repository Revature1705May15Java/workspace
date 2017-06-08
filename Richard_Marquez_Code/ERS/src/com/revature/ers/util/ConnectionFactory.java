package com.revature.ers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "ers";
        String password = "p4ssw0rd";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            Thread.sleep(100);
            return getConnection();
        }
        return conn;

    }





}

