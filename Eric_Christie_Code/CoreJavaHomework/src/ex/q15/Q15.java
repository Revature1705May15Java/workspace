package ex.q15;

public class Q15 {
  public static void main(String[] args) {
    Q q = new Maths(7.5, 8.6);
    System.out.println(q.addition());
    System.out.println(q.multiplication());
  }
}

interface Q {
  double addition();
  double subtraction();
  double multiplication();
  double division();
}

class Maths implements Q{
  
  private double a, b;
  
  public Maths(double a, double b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public double addition() {
    return a + b;
  }

  @Override
  public double subtraction() {
    return a - b;
  }

  @Override
  public double multiplication() {
    return a * b;
  }

  @Override
  public double division() {
    return a / b;
  }
  
}