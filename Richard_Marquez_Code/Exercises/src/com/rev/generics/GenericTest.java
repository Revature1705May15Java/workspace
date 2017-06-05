package com.rev.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        // Initialization
        List nonGen = new ArrayList();
        nonGen.add("asdf");
        nonGen.add(42);

        List<String> gen = new ArrayList<>();
        gen.add("qwerty");
//        gen.add(73); // NOT ok


        // Elimination of casts
        String s1 = (String) nonGen.get(0);
        String s2 = (String) nonGen.get(1);  // ClassCastException at runtime

        String s3 = gen.get(0);


        // Allowable types
        GenBox<Number> nb = new GenBox<>();
        nb.setObj(new Integer(42));
        //nb.setObj(new Object());  // NOT ok


        // Wildcards
        List<Object> objList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        List<String> strList = new ArrayList<>();

        printListNoWildcards(objList);
//        printListNoWildcards(intList);  // NOT ok

        printListUnboundedWildcard(intList);
        printListUnboundedWildcard(strList);

        printListUpperBoundedWildcard(intList);

        printListLowerBoundedWildcard(objList);
        printListLowerBoundedWildcard(intList);
    }

    public static void printListNoWildcards(List<Object> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
    }

    public static void printListUnboundedWildcard(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
    }

    // List is of some type that extends number
    public static void printListUpperBoundedWildcard(List<? extends Number> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
    }

    // Accept any type that can hold an Integer
    public static void printListLowerBoundedWildcard(List<? super Integer> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
    }
}


// Basic usage
class NonGenBox {
    private Object obj;

    public void setObj(Object obj) { this.obj = obj; }
    public Object getObj() { return obj; }
}

class GenBox<T> {
    private T obj;

    public void setObj(T obj) { this.obj = obj; }
    public T getObj() { return obj; }
}


// Bounded parameters
class GenExtClass<T extends Thread> { }
class GenImplInt<T extends Runnable> { }
class GenBoth<T extends Thread & Runnable> { }  // Classes before interfaces


interface Comparable<T> {
    int compareTo(T obj);
}

class ComparisonTester<T extends Comparable<T>> {
    public boolean isGreaterThan(T a, T b) {
        return (a.compareTo(b) > 0);
    }
}
