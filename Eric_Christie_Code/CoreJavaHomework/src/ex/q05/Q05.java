package ex.q05;

public class Q05 {
  static String substr(String s, int idx) {
    String result = "";
    for (int i = 0; i < idx; i++) {
      result += s.charAt(i);
    }
    return result;
  }
}
