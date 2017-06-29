package com.ers.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	
	public static Boolean build = true;
	public static ConnectionFactory cf=null;
	
	private ConnectionFactory(){
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance(){
		if(build==true){
			cf = new ConnectionFactory();
		}
		
		return cf;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		try{
			System.out.println("1");
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/Associate/Desktop/Server/week3/ERS/src/com/ers/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("usr"));
			System.out.println(prop.getProperty("pwd"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Caught");
			
		}
		
		return conn;
	}
}
