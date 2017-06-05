package ex.q13;

public class Q13 {
  public static void main(String[] args) {
    boolean print1 = false;
    int row = 1;
    while (row < 5) {
      String line = "";
      for (int i = 0; i < row; i++) {
        line += print1 ? "1" : "0";
        print1 = !print1;
      }
      System.out.println(line);
      row++;
    }
  }
}
