package com.ex.threads;

public class MyRunnable implements Runnable {

  StringBuffer sbuffer = new StringBuffer("runnable");
  StringBuilder sbuilder = new StringBuilder("runnable");

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(sbuffer.append(i));
    }
  }

  public void run(StringBuilder sb) {
    for (int i = 0; i < 10; i++) {
      System.out.println(sb.append(i));
    }
  }

  public void run(StringBuffer sb) {
    for (int i = 0; i < 10; i++) {
      System.out.println(sb.append(i));
    }
  }

}
