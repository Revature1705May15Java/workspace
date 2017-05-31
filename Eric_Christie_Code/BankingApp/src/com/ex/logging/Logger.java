package com.ex.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
  
  /*
   * this should probably be a singleton
   * 
   * it's probably best to use a singleton logger and have it print to different
   * output files for different methods (logger.error(), logger.log(), ...)
   */
  
  private static String filename = "src/com/ex/logging/log.txt";
  
  private static final Logger INSTANCE = new Logger();

  public static Logger getInstance() {
    return Logger.INSTANCE;
  }
  
  private LocalDateTime now;
  
  private Logger() { super(); }
  
  /**
   * Log a message.
   * @param message
   */
  public void log(String message) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
      now = LocalDateTime.now();
      bw.write(now + " - " + message + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Log a message labeled as something problematic. Use this when errors or exceptions occur.
   * @param message
   */
  public void alert(String message) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
      now = LocalDateTime.now();
      bw.write(now + " - ALERT: " + message + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
