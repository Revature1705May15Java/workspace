package ex.q04;

public class Q04 {

  static int factorial(int N) {
    if (N == 1) {
      return 1;
    } else {
      return N * factorial(N - 1);
    }
  }

}
