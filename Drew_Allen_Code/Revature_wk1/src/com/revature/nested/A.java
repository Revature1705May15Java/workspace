package com.revature.nested;

public class A {
    /* Class A will be the outer class to the staic class B
     * 
     */
    
    static int data = 30;
    int x = 10;
    
    static class B{
        static int data = 0;
        void message(){
            A ch = new A();
            System.out.println("In my outer class! Data is " + data);
            System.out.println(ch.x);
        }
    }
    
    public static void main(String[] args) {
        A.B objectOfB = new A.B();
        // in order to create an object of B, we must use [outerclass]+[innerclass]
        
        objectOfB.message();
    }
}
class C{
    A a = new A();
    //B b = new B();// cannot do this
    A.B b = new A.B();// do this instead
    public static void main(String[] args) {
        System.out.println("Wow");
    }
}
