package com.revature.ers.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectionFactory {

  private static Boolean build = true;
  private static ConnectionFactory INSTANCE = null;
  private static String propertiesFile = "C:/Users/Eric/Employment/Revature/workspace/Eric_Christie_Code/ERS/"
      + "src/com/revature/ers/util/database.properties";
  
  public static synchronized ConnectionFactory getInstance() {
    if (build == true) {
      INSTANCE = new ConnectionFactory();
    }
    return INSTANCE;
  }
  
  private TempLogger logger = new TempLogger();
  
  private ConnectionFactory() {
    build = false;
  }
  
  public Connection getConnection() {
    Connection connection = null;
    try {
      Properties p = new Properties();
      p.load(new FileReader(propertiesFile));
      Class.forName(p.getProperty("driver"));
      connection = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
          p.getProperty("password"));
    } catch (Exception e) {
      logger.catching(e);
    }
    return connection;
  }
  
}
