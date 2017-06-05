package com.bank.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	
	private static Boolean build = true;
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory(){
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance(){
		if(build == true){
			cf = new ConnectionFactory();
		}
		
		return cf;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		
		try{
			Properties prop =  new Properties();
			prop.load(new FileReader("C:/Users/Darrin McIntyre/my_git_repos/1705May15Java/week3/workspace_week_3/Freemarker_Banking/src/com/bank/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
