package ex.q14;

import java.time.LocalDate;

public class Q14 {
  public static void main(String[] args) {
    Integer input = Integer.parseInt(args[0]);
    switch (input) {
    case 1:
      double x = 1000*Math.random();
      System.out.println(Math.sqrt(x) + " is the square root of " + x);
      break;
    case 2:
      System.out.println("Today is " + LocalDate.now());
      break;
    case 3:
      String s = "I am learning Core Java";
      String[] sa = s.split(" ");
      for (String str: sa) {
        System.out.println(str);
      }
      break;
    }
  }
}
