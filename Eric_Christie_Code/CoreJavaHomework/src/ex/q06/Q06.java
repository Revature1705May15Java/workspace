package ex.q06;

public class Q06 {
  static boolean isEven(int n) {
    boolean answer = false;
    String num = ((Integer) n).toString();
    char digit = num.charAt(num.length() - 1);
    if (digit == '0' || digit == '2' || digit == '4' || digit == '6' || digit == '8') {
      answer = true;
    }
    return answer;
  }
  
  public static void main(String[] args) {
    int input = Integer.parseInt(args[1]);
    System.out.println(isEven(input));
  }
}
