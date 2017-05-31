package com.ex.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.ex.logging.Logger;

public class ConnectionFactory {

  private static Boolean build = true;
  private static ConnectionFactory INSTANCE = null;
  private static String propertiesFile = /*"C:Users/Eric/Employment/Revature/workspace/Eric_Christie_Code/BankingApp/" +*/ "src/com/ex/util/database.properties";
  
  public static synchronized ConnectionFactory getInstance() {
    if (build == true) {
      INSTANCE = new ConnectionFactory();
    }
    return INSTANCE;
  }
  
  private Logger logger;
  
  private ConnectionFactory() {
    build = false;
    logger = Logger.getInstance();
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
      logger.alert(e.getMessage());
      e.printStackTrace();
    }
    return connection;
  }
  
}
