package com.revature.ers.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A logger class to use while I work on figuring out log4j.
 * @author Eric
 *
 */
public class TemporaryLogger {
  
  @SuppressWarnings("unused")
  private static final String filename = "C:/Users/Eric/Employment/Revature/workspace/Eric_Christie_Code/ERS/"
      + "src/com/revature/ers/util/log.txt";
  
  private static final Logger logger = LogManager.getLogger("TemporaryLogger");
  
  
  public void log(String message) {
    System.out.println(message);
  }
  
  public void catching(Throwable t) {
    logger.catching(Level.ERROR, t);
  }
  
  public void debug(String message) {
    logger.debug(message);
  }
  
  public void error(String message) {
    logger.error(message);
  }
  
  public void fatal(String message) {
    logger.fatal(message);
  }
  
  public void info(String message) {
    logger.info(message);
  }
  
  public void throwing(Throwable t) {
    logger.throwing(Level.WARN, t);
  }
  
  public void trace(String message) {
    logger.trace(message);
  }
  
  public void warn(String message) {
    logger.warn(message);
  }

}
