package ex.q17;

import java.util.Scanner;

public class Q17 {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    System.out.println("input a principal amount:");
    Double p = Double.parseDouble(in.nextLine());
    System.out.println("input an annual rate:");
    Double r = Double.parseDouble(in.nextLine());
    System.out.println("input a number of years:");
    Double t = Double.parseDouble(in.nextLine());
    System.out.println("Simple interest = " + p * r * t);
  }
}
