package com.revature.ers.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * This logger class is for me to use until I figure out how to use log4j.
 * @author Eric
 *
 */
public class TempLogger {
  
  private static final String filename = "C:/Users/Eric/Employment/Revature/workspace/Eric_Christie_Code/ERS/"
      + "src/com/revature/ers/util/log.txt";
  private static final String debugLogfile = "C:/Users/Eric/Employment/Revature/workspace/Eric_Christie_Code/ERS/"
      + "src/com/revature/ers/util/debug-log.txt";
  private static final String serverLogfile = "C:/Users/Eric/Employment/Revature/workspace/Eric_Christie_Code/ERS/"
      + "src/com/revature/ers/util/server-log.txt";
  
  // logging the server requests and responses should probably only be done while debugging
  
  public static void serverLog(String message) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(serverLogfile, true));) {
      bw.write(LocalDateTime.now() + " - SERVER: " + message + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
    // TODO finish implementing this request/response logging method
//  public static void serverLog(HttpServletRequest req, HttpServletResponse res) {
//    try (BufferedWriter bw = new BufferedWriter(new FileWriter(serverLogfile, true));) {
//      String requestLog = LocalDateTime.now() + " - " + req.getMethod() + " " + req.getRequestURI() + "?" + req.getQueryString() + "\n";
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
  
  public static void serverLogRequest(String message) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(serverLogfile, true));) {
      bw.write(LocalDateTime.now() + " - REQUEST: " + message + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void serverLogResponse(String message) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(serverLogfile, true));) {
      bw.write(LocalDateTime.now() + " - RESPONSE: " + message + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void log(String message) {
//    System.out.println(message);
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
      bw.write(LocalDateTime.now() + " - " + message + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void catching(Throwable t) {
    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));) {
      pw.write(LocalDateTime.now() + " - CAUGHT: " + t.toString() + " with stack trace:\n");
      t.printStackTrace(pw);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void debug(String message) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(debugLogfile, true));) {
      bw.write(LocalDateTime.now() + " - DEBUG: " + message + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void error(String message) {
    log("ERROR: " + message);
  }
  
  public void fatal(String message) {
    log("FATAL: " + message);
  }
  
  public void info(String message) {
    log("INFO: " + message);
  }
  
  public void throwing(Throwable t) {
    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));) {
      pw.write(LocalDateTime.now() + " THROWING " + t.toString() /*+ " with stack trace:\n"*/);
//      t.printStackTrace(pw);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void trace(String message) {
    log("TRACE: " + message);
  }
  
  public void warn(String message) {
    log("WARN: " + message);
  }

}
