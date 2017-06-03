package com.revature.ers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory INSTANCE = new ConnectionFactory();

    private ConnectionFactory() {
        //
    }

    public static ConnectionFactory getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "ers";
        String password = "p4ssw0rd";

//		try {
//			Properties prop = new Properties();
//			prop.load(new FileReader("C:/propfilepash"));
//			Class.forName(prop.getProperty("driver"));

//			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(url, username, password);
    }
}
