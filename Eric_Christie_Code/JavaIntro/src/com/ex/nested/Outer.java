package com.ex.nested;

public class Outer {
  /*
   * This will be the outer class for a static inner class
   * 
   */

  String instanceData = "Outer: instance data";
  static String staticData = "Outer: static data";
  @SuppressWarnings("unused")
  private String privateInstanceData = "Outer: private instance data";
  @SuppressWarnings("unused")
  private static String privateStaticData = "Outer: private static data";

  static class StaticInner {
    static String staticInnerData = "StaticInner: static inner data";
    static String staticData = "StaticInner: static data";
    String staticInnerInstanceData = "StaticInner: static inner instance data";
    String instanceData = "StaticInner: instance data";

    void message() {
      System.out.println("I'm in an inner class!\nMy data is " + staticData);
      System.out.println("I can still use data from Outer via Outer.staticData = " + Outer.staticData);
      // System.out.println("I can't access instance methods: " + instanceVar);
      System.out.println(this.getClass());
    }
  }

  class MemberInner {
    String instanceData = "MemberInner: member inner data"; // this is called
                                                            // shadowing
    // inner class's instance variable shadows the outer class's instance
    // variable of the same name
    String memberInnerInstanceData = "MemberInner: member inner instance data";

    void message() {
      System.out.println("I'm in a member inner class!");
    }
  }

  static void makeLocalInnerClass() {
    class LocalInner {
      String localInnerInstanceData = "LocalInner: local inner data";

      void doWork() {
        System.out.println("LocalInner instance is lazy and refuses to work.");
      }

      void printData() {
        System.out.println(localInnerInstanceData);
      }
    }

    LocalInner li = new LocalInner();
    li.printData();
    li.doWork();
  }

  public static void main(String[] args) {
    Outer.StaticInner si = new Outer.StaticInner();
    // the 'Outer.' can be omitted when you're still within the outer class
    si.message();

    Outer o = new Outer();
    @SuppressWarnings("unused")
    MemberInner mi = o.new MemberInner();

    makeLocalInnerClass();

    AbstractAnonymous aa = new AbstractAnonymous() {
      void blah() {
        System.out.println("blah");
      }
    };
    aa.blah();

    Anonymous a = new Anonymous() {
      void blargh() {
        super.blargh();
        System.out.println("Actually, the correct spelling is blargh.");
      }
    };
    a.blargh();
  }

}

abstract class AbstractAnonymous {
  abstract void blah();
}

class Anonymous {
  void blargh() {
    System.out.println("blarg");
  }
}

class Other {
  Outer outer = new Outer();
  // StaticInner innerStatic = new StaticInner(); // this doesnt work
  Outer.StaticInner staticInnerObj = new Outer.StaticInner();
}
