package com.ex.p2;

public class Fibonacci {

  static int[] fibonacci(int N) {
    int[] result = new int[N];
    for (int i = 0; i < N; i++) {
      if (i == 0) {
        result[i] = 0;
      } else if (i == 1) {
        result[i] = 1;
      } else {
        result[i] = result[i - 1] + result[i - 2];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] answer = fibonacci(25);
    for (int i : answer) {
      System.out.println(i);
    }
  }

}
