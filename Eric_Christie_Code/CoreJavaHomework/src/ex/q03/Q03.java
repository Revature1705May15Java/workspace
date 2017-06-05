package ex.q03;

public class Q03 {
  static String reverseString(String s) {
    String result = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      result += s.charAt(i);
    }
    return result;
  }
  
  public static void main(String[] args) {
    System.out.println("blah blah BLAH");
    System.out.println(reverseString("blah blah BLAH"));
  }
}
